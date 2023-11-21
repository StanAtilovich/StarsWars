package ru.stan.starswars.domain.repository

import androidx.paging.Pager
import ru.stan.starswars.domain.model.PeopleItem

interface PeopleRepo {
    fun getPager(): Pager<Int, PeopleItem>
    suspend fun getPeopleFromDb():List<PeopleItem>
    suspend fun insertPeopleItemToDb(peopleItem: PeopleItem)
    suspend fun changeFavoriteState(peopleItem: PeopleItem)
    suspend fun removePeopleItem(peopleItem: PeopleItem)
}