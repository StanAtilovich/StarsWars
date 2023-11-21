package ru.stan.starswars.presentation.shipFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.stan.starswars.domain.model.ShipItem
import ru.stan.starswars.domain.useCase.GetPagerWithShipUseCase
import ru.stan.starswars.domain.useCase.RemoveShipItemUseCase
import ru.stan.starswars.domain.useCase.SaveShipItemToDbUseCase
import javax.inject.Inject

class ShipViewModel @Inject constructor(
    private val useCasePager: GetPagerWithShipUseCase,
    private val saveItemUseCase: SaveShipItemToDbUseCase,
    private val removeShipItemUseCase: RemoveShipItemUseCase
) : ViewModel() {
val item: Flow<PagingData<ShipItem>> =
    useCasePager().flow.cachedIn(viewModelScope)

    fun saveItem(shipItem: ShipItem){
        viewModelScope.launch(Dispatchers.IO){
            saveItemUseCase(shipItem.copy(isFavorite = true))
        }
    }
    fun removeItem(shipItem: ShipItem){
        viewModelScope.launch(Dispatchers.IO){
            removeShipItemUseCase(shipItem.copy(isFavorite = false))
        }
    }
}