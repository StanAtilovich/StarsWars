package ru.stan.starswars.presentation.planetFragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.stan.starswars.App
import ru.stan.starswars.R
import ru.stan.starswars.databinding.PlanetItemBinding
import ru.stan.starswars.domain.model.PlanetItem
import javax.inject.Inject

class PlanetAdapter @Inject constructor(
    private val viewModel: PlanetViewModel
) : PagingDataAdapter<PlanetItem,
        PlanetAdapter.PlanetListViewHolder>(callback) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PlanetListViewHolder {
        val binding =
            PlanetItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PlanetListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PlanetListViewHolder, position: Int
    ) {
        val planetItem = getItem(position)
        planetItem?.let { holder.bind(it)}
    }

    inner class PlanetListViewHolder(
       private val binding: PlanetItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(planetItem: PlanetItem){
            binding.tvName.text = planetItem.name
            binding.tvDiameter.text = planetItem.diameter
            binding.tvPopulation.text = planetItem.population
            binding.btnFavourite.addOnCheckedChangeListener { button, isChecked ->
                if (isChecked) {
                    viewModel.saveItem(planetItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.favorite_icon)
                } else {
                    viewModel.removeItem(planetItem)
                    button.icon = App.INSTANCE.getDrawable(R.drawable.not_favorite_icon)
                }
            }
        }
    }


    companion object {
        val callback = object : DiffUtil.ItemCallback<PlanetItem>() {
            override fun areItemsTheSame(oldItem: PlanetItem, newItem: PlanetItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: PlanetItem, newItem: PlanetItem): Boolean {
                return oldItem == newItem
            }

        }
    }


}