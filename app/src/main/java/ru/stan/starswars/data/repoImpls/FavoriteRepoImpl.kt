package ru.stan.starswars.data.repoImpls

import ru.stan.starswars.data.room.dao.ItemDao
import ru.stan.starswars.data.room.mapper.MapperDbModel
import ru.stan.starswars.domain.model.FavoriteItem
import ru.stan.starswars.domain.repository.FavouriteRepo
import javax.inject.Inject

class FavoriteRepoImpl @Inject constructor(
    private val dao: ItemDao,
    private val mapper: MapperDbModel
) : FavouriteRepo {
    override suspend fun getFavoriteRepo(): List<FavoriteItem> {
        return mapper.mapItemDbToFavouriteItem_list(
            dao.getAllItems()
        )
    }

}