package ru.stan.starswars.data.repoImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ru.stan.starswars.data.network.dataSources.ShipDataSource
import ru.stan.starswars.data.room.dao.ItemDao
import ru.stan.starswars.data.room.mapper.MapperDbModel
import ru.stan.starswars.domain.model.ShipItem
import ru.stan.starswars.domain.repository.ShipRepo
import javax.inject.Inject

class ShipRepoItem @Inject constructor(
    private val pagingSource: ShipDataSource,
    private val dao: ItemDao,
    private val mapper: MapperDbModel
) : ShipRepo {
    override fun getPager() = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { pagingSource }
    )

    override suspend fun getShipFromDb(): List<ShipItem> {
       return dao.getAllItemsByType(MapperDbModel.SHIP_TYPE).map {
           mapper.mapDbModelToShipItem(it)
       }
    }

    override suspend fun insertShipItemToDb(shipItem: ShipItem) {
       dao.insertItem(
           mapper.mapShipToDbModel(shipItem)
       )
    }

    override suspend fun changeFavoriteState(shipItem: ShipItem) {
        dao.insertItem(
            mapper.mapShipToDbModel(
                shipItem.copy(
                    isFavorite = !shipItem.isFavorite
                )
            )
        )
    }

    override suspend fun removeShipItem(shipItem: ShipItem) {
        dao.removeItem(shipItem.name, MapperDbModel.SHIP_TYPE)
    }

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }
}