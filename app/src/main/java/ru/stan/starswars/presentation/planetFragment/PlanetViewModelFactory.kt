package ru.stan.starswars.presentation.planetFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PlanetViewModelFactory @Inject constructor(
    private val viewModel: PlanetViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanetViewModel::class.java)) {
            return viewModel as T
        }
        throw IllegalAccessException("ошибка в планет фабрике")
    }
}