package ru.stan.starswars.presentation.favoriteFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class FavouriteViewModelFactory @Inject constructor(
    private val viewModel: FavoriteViewModel
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name: $modelClass")
    }
}