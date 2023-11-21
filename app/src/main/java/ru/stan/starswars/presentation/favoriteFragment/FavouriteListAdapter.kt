package ru.stan.starswars.presentation.favoriteFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.stan.starswars.App
import ru.stan.starswars.R
import ru.stan.starswars.databinding.FavoriteItemBinding
import ru.stan.starswars.domain.model.FavoriteItem

class FavouriteListAdapter : ListAdapter<FavoriteItem,
        FavouriteListAdapter.FavouriteListViewHolder>(callback) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): FavouriteListViewHolder {

        val binding =
            FavoriteItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return FavouriteListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: FavouriteListViewHolder, position: Int
    ) {
        val favouriteItem = getItem(position)
        favouriteItem?.let { holder.bind(it) }
    }

    inner class FavouriteListViewHolder(
        val binding: FavoriteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(favouriteItem: FavoriteItem) {
            binding.tvName.text = favouriteItem.name
            binding.tvField2.text = favouriteItem.field2
            binding.tvField3.text = favouriteItem.field3
            binding.tvType.text = favouriteItem.type
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked){
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }

    companion object {
        val callback = object : DiffUtil.ItemCallback<FavoriteItem>() {
            override fun areItemsTheSame(oldItem: FavoriteItem, newItem: FavoriteItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: FavoriteItem, newItem: FavoriteItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}