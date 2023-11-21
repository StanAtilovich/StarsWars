package ru.stan.starswars.data.network.dataSources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ru.stan.starswars.data.network.api.RetrofitInstance
import ru.stan.starswars.data.network.mapper.DtoMapper
import ru.stan.starswars.domain.model.PlanetItem
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min

class PlanetDataSource @Inject constructor(
    private val mapper: DtoMapper
) : PagingSource<Int, PlanetItem>() {

    override fun getRefreshKey(state: PagingState<Int, PlanetItem>): Int {
        return STARTING_PAGE
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PlanetItem> {
        val page = params.key ?: STARTING_PAGE
        return kotlin.runCatching {
            RetrofitInstance.searchDataApi.getPlanets(page=page, format = "json").results.map {
                mapper.mapPlanetDtoToDomainItem(it)
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


    private fun ensureValidKey(page: Int) = min(max(STARTING_PAGE, page), LAST_PAGE)

    companion object {
        private const val STARTING_PAGE = 1
        private const val LAST_PAGE = 6
    }

}