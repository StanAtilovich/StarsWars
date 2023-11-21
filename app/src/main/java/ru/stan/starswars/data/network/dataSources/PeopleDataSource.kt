package ru.stan.starswars.data.network.dataSources

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.stan.starswars.data.network.api.RetrofitInstance
import ru.stan.starswars.data.network.mapper.DtoMapper
import ru.stan.starswars.domain.model.PeopleItem
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min

class PeopleDataSource @Inject constructor(
    private val mapper: DtoMapper
) : PagingSource<Int, PeopleItem>() {

    override fun getRefreshKey(state: PagingState<Int, PeopleItem>): Int {
        return STARTING_PAGE
    }


    override suspend fun load(params: LoadParams<Int>)
    : LoadResult<Int, PeopleItem> {
        val page = params.key ?: STARTING_PAGE


       return kotlin.runCatching {
            RetrofitInstance.searchDataApi.getPeople(page=page, format = "json").results.map {
                Log.d("aslan555", "$it")
                mapper.mapPeopleDtoToDomainItem(it)
            }
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (page == LAST_PAGE) null else ensureValidKey(page + 1)
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }



    private fun ensureValidKey(page:Int)= min(max(STARTING_PAGE, page), LAST_PAGE)

    companion object {
        private const val STARTING_PAGE = 1
        private const val LAST_PAGE = 9
    }

}