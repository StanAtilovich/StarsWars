package ru.stan.starswars.data.repoImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ru.stan.starswars.data.network.dataSources.PlanetDataSource
import ru.stan.starswars.data.room.dao.ItemDao
import ru.stan.starswars.data.room.mapper.MapperDbModel
import ru.stan.starswars.domain.model.PlanetItem
import ru.stan.starswars.domain.repository.PlanetRepo
import javax.inject.Inject

class PlanetRepoImpl@Inject constructor(
    private val pagingSource: PlanetDataSource,
    private val dao: ItemDao,
    private val mapper: MapperDbModel
): PlanetRepo {
    override fun getPager()= Pager(
        config = PagingConfig(PlanetRepoImpl.ITEM_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { pagingSource }
    )

    override suspend fun getPlanetFromDb(): List<PlanetItem> {
        return dao.getAllItemsByType(MapperDbModel.PLANET_TYPE).map {
            mapper.mapDbModelToPlanetItem(it)
        }
    }

    override suspend fun insertPlanetItemToDb(planetItem: PlanetItem) {
        dao.insertItem(
            mapper.mapPlanetToDbModel(planetItem)
        )
    }

    override suspend fun changeFavoriteState(planetItem: PlanetItem) {
        dao.insertItem(
            mapper.mapPlanetToDbModel(
                planetItem.copy(
                    isFavorite = !planetItem.isFavorite
                )
            )
        )
    }

    override suspend fun removePlanetItem(planetItem: PlanetItem) {
        dao.removeItem(planetItem.name, MapperDbModel.PLANET_TYPE)
    }


    companion object{
        private const val ITEM_PER_PAGE = 10
    }
}