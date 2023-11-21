package ru.stan.starswars.presentation.planetFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import ru.stan.starswars.domain.useCase.GetPagerWithPlanetUseCase
import ru.stan.starswars.domain.useCase.RemovePlanetItemUseCase
import ru.stan.starswars.domain.useCase.SavePlanetItemToDbUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ru.stan.starswars.domain.model.PlanetItem
import javax.inject.Inject

class PlanetViewModel @Inject constructor(
    private val useCasePager: GetPagerWithPlanetUseCase,
    private val saveItemUseCase: SavePlanetItemToDbUseCase,
    private val removePlanetItemUseCase: RemovePlanetItemUseCase
) : ViewModel() {
    val item: Flow<PagingData<PlanetItem>> =
        useCasePager().flow.cachedIn(viewModelScope)

    fun saveItem(planetItem: PlanetItem){
        viewModelScope.launch(Dispatchers.IO){
            saveItemUseCase(planetItem.copy(isFavorite = true))
        }
    }
    fun removeItem(planetItem: PlanetItem){
        viewModelScope.launch(Dispatchers.IO){
            removePlanetItemUseCase(planetItem.copy(isFavorite = false))
        }
    }
}