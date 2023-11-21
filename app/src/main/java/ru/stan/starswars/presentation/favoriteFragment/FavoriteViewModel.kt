package ru.stan.starswars.presentation.favoriteFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.stan.starswars.domain.model.FavoriteItem
import ru.stan.starswars.domain.useCase.GetFavoriteItemUseCase
import javax.inject.Inject

private const val TAG = "FavouritesViewModel"

class FavoriteViewModel @Inject constructor(
    private val useCasePager: GetFavoriteItemUseCase
) : ViewModel() {
    private val _items = MutableStateFlow<List<FavoriteItem>>(emptyList())
    val items = _items.asStateFlow()

    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                useCasePager()
            }.fold(
                onSuccess = { _items.value = it },
                onFailure = { Log.e(TAG, "${it.message}", it) }
            )
        }
    }
}