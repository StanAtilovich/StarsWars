package ru.stan.starswars.presentation.peopleFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.stan.starswars.App
import ru.stan.starswars.R
import ru.stan.starswars.databinding.PeopleItemBinding
import ru.stan.starswars.domain.model.PeopleItem
import javax.inject.Inject

class PeopleAdapter @Inject constructor(
    private val viewModel: PeopleViewModel
) : PagingDataAdapter<PeopleItem, PeopleAdapter.PeopleListViewHolder>(callback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleListViewHolder {
        val binding =
            PeopleItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return PeopleListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleListViewHolder, position: Int) {
        val peopleItem = getItem(position)
        peopleItem?.let { holder.bind(peopleItem) }
    }


    inner class PeopleListViewHolder(
        val binding: PeopleItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(peopleItem: PeopleItem) {
            binding.tvName.text = peopleItem.name
            binding.tvGender.text = peopleItem.gender
            binding.tvShipCount.text = peopleItem.birth_year
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked) {
                    viewModel.saveItem(peopleItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    viewModel.removeItem(peopleItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }


companion object {
    val callback = object : DiffUtil.ItemCallback<PeopleItem>() {
        override fun areItemsTheSame(oldItem: PeopleItem, newItem: PeopleItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PeopleItem, newItem: PeopleItem): Boolean {
            return oldItem == newItem
        }

    }
}


}