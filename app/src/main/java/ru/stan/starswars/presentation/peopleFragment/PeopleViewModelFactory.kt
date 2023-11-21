package ru.stan.starswars.presentation.peopleFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PeopleViewModelFactory @Inject constructor(
    private val viewModel: PeopleViewModel
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PeopleViewModel::class.java)) {
            return viewModel as T
        }
        throw IllegalAccessException("Ошибка в Фабрике Людей")

    }
}
