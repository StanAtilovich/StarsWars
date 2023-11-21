package ru.stan.starswars.domain.useCase

import ru.stan.starswars.domain.repository.FavouriteRepo
import javax.inject.Inject

class GetFavoriteItemUseCase@Inject constructor(
    private val repo: FavouriteRepo
) {
    suspend operator fun invoke()= repo.getFavoriteRepo()
}