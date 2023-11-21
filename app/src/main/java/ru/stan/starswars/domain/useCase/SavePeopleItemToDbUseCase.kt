package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.model.PeopleItem
import ru.stan.starswars.domain.repository.PeopleRepo
import javax.inject.Inject

class SavePeopleItemToDbUseCase@Inject constructor(
    private val repo: PeopleRepo
) {
    suspend operator fun invoke(peopleItem: PeopleItem){
        repo.insertPeopleItemToDb(peopleItem)
    }
}