package ru.stan.starswars.domain.repository

import androidx.paging.Pager
import ru.stan.starswars.domain.model.ShipItem

interface ShipRepo {
    fun getPager(): Pager<Int, ShipItem>
    suspend fun getShipFromDb():List<ShipItem>
    suspend fun insertShipItemToDb(shipItem: ShipItem)
    suspend fun changeFavoriteState(shipItem: ShipItem)
    suspend fun removeShipItem(shipItem: ShipItem)
}