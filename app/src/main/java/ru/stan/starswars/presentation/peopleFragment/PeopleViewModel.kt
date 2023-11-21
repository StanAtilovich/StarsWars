package ru.stan.starswars.presentation.peopleFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.stan.starswars.domain.model.PeopleItem
import ru.stan.starswars.domain.useCase.GetPagerWithPeopleUseCase
import ru.stan.starswars.domain.useCase.RemovePeopleItemUseCase
import ru.stan.starswars.domain.useCase.SavePeopleItemToDbUseCase
import javax.inject.Inject

class PeopleViewModel @Inject constructor(
    private val useCasePager: GetPagerWithPeopleUseCase,
    private val saveItemUseCase: SavePeopleItemToDbUseCase,
    private val removePeopleItemUseCase: RemovePeopleItemUseCase
) : ViewModel() {


    val item: Flow<PagingData<PeopleItem>> = useCasePager()
        .flow
        .cachedIn(viewModelScope)

    fun saveItem(peopleItem: PeopleItem){
        viewModelScope.launch(Dispatchers.IO) {
            saveItemUseCase(peopleItem.copy(isFavorite = true))
        }
    }

    fun removeItem(peopleItem: PeopleItem) {
        viewModelScope.launch(Dispatchers.IO) {
            removePeopleItemUseCase(peopleItem.copy(isFavorite = false))
        }
    }

}