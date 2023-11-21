package ru.stan.starswars.domain.repository

import ru.stan.starswars.domain.model.FavoriteItem

interface FavouriteRepo {
    suspend fun getFavoriteRepo():List<FavoriteItem>
}