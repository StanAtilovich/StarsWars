package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.repository.ShipRepo
import javax.inject.Inject

class GetPagerWithShipUseCase @Inject constructor(
    private val repo: ShipRepo
) {
    operator fun invoke() = repo.getPager()
}