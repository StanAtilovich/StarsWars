package ru.stan.starswars.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.stan.starswars.data.repoImpls.FavoriteRepoImpl
import ru.stan.starswars.data.repoImpls.PeopleRepoImpl
import ru.stan.starswars.data.repoImpls.PlanetRepoImpl
import ru.stan.starswars.data.repoImpls.ShipRepoItem
import ru.stan.starswars.domain.repository.FavouriteRepo
import ru.stan.starswars.domain.repository.PeopleRepo
import ru.stan.starswars.domain.repository.PlanetRepo
import ru.stan.starswars.domain.repository.ShipRepo

@Module
@InstallIn(SingletonComponent::class)
interface BindsImpl {

    @Binds
    fun bindsPeopleImpl(
        peopleRepoImpl: PeopleRepoImpl
    ): PeopleRepo

    @Binds
    fun bindsPlanetImpl(
        planetRepoImpl: PlanetRepoImpl
    ): PlanetRepo

    @Binds
    fun bindsShipImpl(
        shipRepoImpl: ShipRepoItem
    ): ShipRepo

    @Binds
    fun bindsFavoriteImpl(
        favoriteRepoImpl: FavoriteRepoImpl
    ): FavouriteRepo
}