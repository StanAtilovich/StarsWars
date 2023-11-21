package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.model.ShipItem
import ru.stan.starswars.domain.repository.ShipRepo
import javax.inject.Inject

class RemoveShipItemUseCase @Inject constructor(
    private val repo: ShipRepo
) {
    suspend operator fun invoke(shipItem: ShipItem) {
        repo.removeShipItem(shipItem)
    }
}