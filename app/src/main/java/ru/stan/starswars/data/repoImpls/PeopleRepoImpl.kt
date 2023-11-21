package ru.stan.starswars.data.repoImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ru.stan.starswars.data.network.dataSources.PeopleDataSource
import ru.stan.starswars.data.room.dao.ItemDao
import ru.stan.starswars.data.room.mapper.MapperDbModel
import ru.stan.starswars.domain.model.PeopleItem
import ru.stan.starswars.domain.repository.PeopleRepo
import javax.inject.Inject

class PeopleRepoImpl @Inject constructor(
    private val pagingSource: PeopleDataSource,
    private val dao: ItemDao,
    private val mapper: MapperDbModel
): PeopleRepo {
    override fun getPager()= Pager(
        config = PagingConfig(ITEM_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { pagingSource }
    )

    override suspend fun getPeopleFromDb(): List<PeopleItem> {
       return dao.getAllItemsByType(MapperDbModel.PEOPLE_TYPE).map {
           mapper.mapDbModelToPeopleItem(it)
       }
    }

    override suspend fun insertPeopleItemToDb(peopleItem: PeopleItem) {
        dao.insertItem(
            mapper.mapPeopleToDbModel(peopleItem)
        )
    }

    override suspend fun changeFavoriteState(peopleItem: PeopleItem) {
        dao.insertItem(
            mapper.mapPeopleToDbModel(
                peopleItem.copy(
                    isFavorite = !peopleItem.isFavorite
                )
            )
        )
    }

    override suspend fun removePeopleItem(peopleItem: PeopleItem) {
        dao.removeItem(
            peopleItem.name,MapperDbModel.PEOPLE_TYPE
        )
    }
    companion object{
        private const val ITEM_PER_PAGE = 10
    }
}