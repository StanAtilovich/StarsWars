package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.repository.PlanetRepo
import javax.inject.Inject

class GetPagerWithPlanetUseCase @Inject constructor(
    private val repo: PlanetRepo
) {
    operator fun invoke() = repo.getPager()
}