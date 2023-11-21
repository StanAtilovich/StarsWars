package ru.stan.starswars.presentation.shipFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ShipViewModelFactory @Inject constructor(
    private val viewModel: ShipViewModel
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShipViewModel::class.java)){
            return viewModel as T
        }
        throw IllegalAccessException("Ошибка в фабрике кораблей")
    }
}