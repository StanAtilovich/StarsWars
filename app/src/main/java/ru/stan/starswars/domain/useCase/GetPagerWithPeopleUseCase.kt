package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.repository.PeopleRepo
import javax.inject.Inject

class GetPagerWithPeopleUseCase @Inject constructor(
    private val repo: PeopleRepo
) {
    operator fun invoke() = repo.getPager()
}