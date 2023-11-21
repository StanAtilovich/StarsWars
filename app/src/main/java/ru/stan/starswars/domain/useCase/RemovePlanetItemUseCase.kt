package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.model.PlanetItem
import ru.stan.starswars.domain.repository.PlanetRepo
import javax.inject.Inject

class RemovePlanetItemUseCase@Inject constructor(
    private val repo: PlanetRepo
) {
    suspend operator fun invoke(planetItem: PlanetItem){
        repo.removePlanetItem(planetItem)
    }
}