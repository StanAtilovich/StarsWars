package ru.stan.starswars.domain.repository

import androidx.paging.Pager
import ru.stan.starswars.domain.model.PlanetItem

interface PlanetRepo {
    fun getPager(): Pager<Int, PlanetItem>
    suspend fun getPlanetFromDb():List<PlanetItem>
    suspend fun insertPlanetItemToDb(planetItem: PlanetItem)
    suspend fun changeFavoriteState(planetItem: PlanetItem)
    suspend fun removePlanetItem(planetItem: PlanetItem)
}