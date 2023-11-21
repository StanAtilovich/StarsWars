package ru.stan.starswars.data.network.mapper

import ru.stan.starswars.data.network.dto.PeopleDto
import ru.stan.starswars.data.network.dto.PlanetDto
import ru.stan.starswars.data.network.dto.StarsShipsDto
import ru.stan.starswars.domain.model.PeopleItem
import ru.stan.starswars.domain.model.PlanetItem
import ru.stan.starswars.domain.model.ShipItem
import javax.inject.Inject

class DtoMapper @Inject constructor() {
    fun mapPeopleDtoToDomainItem(peopleDto: PeopleDto) = PeopleItem(
        peopleDto.birth_year,
        peopleDto.created,
        peopleDto.edited,
        peopleDto.eye_color,
        peopleDto.films,
        peopleDto.gender,
        peopleDto.hair_color,
        peopleDto.height,
        peopleDto.homeworld,
        peopleDto.mass,
        peopleDto.name,
        peopleDto.skin_color,
        peopleDto.species,
        peopleDto.starships,
        peopleDto.url,
        peopleDto.vehicles,
        peopleDto.id,
        peopleDto.isFavourite
    )

    fun mapPeopleItemDomainToDto(peopleItem: PeopleItem) = PeopleDto(
        peopleItem.birth_year,
        peopleItem.created,
        peopleItem.edited,
        peopleItem.eye_color,
        peopleItem.films,
        peopleItem.gender,
        peopleItem.hair_color,
        peopleItem.height,
        peopleItem.homeworld,
        peopleItem.mass,
        peopleItem.name,
        peopleItem.skin_color,
        peopleItem.species,
        peopleItem.starships,
        peopleItem.url,
        peopleItem.vehicles,
        peopleItem.id,
        peopleItem.isFavorite
    )

    fun mapPlanetDtoToDomainItem(planetDto: PlanetDto) = PlanetItem(
        planetDto.climate,
        planetDto.created,
        planetDto.diameter,
        planetDto.edited,
        planetDto.films,
        planetDto.gravity,
        planetDto.name,
        planetDto.orbital_period,
        planetDto.population,
        planetDto.residents,
        planetDto.rotation_period,
        planetDto.surface_water,
        planetDto.terrain,
        planetDto.url,
        planetDto.id,
        planetDto.isFavourite
    )

    fun mapPlanetDomainItemToDto(planetItem: PlanetItem) = PlanetDto(
        planetItem.climate,
        planetItem.created,
        planetItem.diameter,
        planetItem.edited,
        planetItem.films,
        planetItem.gravity,
        planetItem.name,
        planetItem.orbital_period,
        planetItem.population,
        planetItem.residents,
        planetItem.rotation_period,
        planetItem.surface_water,
        planetItem.terrain,
        planetItem.url,
        planetItem.id,
        planetItem.isFavorite
    )

    fun mapStarsShipsDtoToStarsShipsItem(starshipsDto: StarsShipsDto) = ShipItem(
        starshipsDto.MGLT,
        starshipsDto.cargo_capacity,
        starshipsDto.consumables,
        starshipsDto.cost_in_credits,
        starshipsDto.created,
        starshipsDto.crew,
        starshipsDto.edited,
        starshipsDto.films,
        starshipsDto.hyperdrive_rating,
        starshipsDto.length,
        starshipsDto.manufacturer,
        starshipsDto.max_atmosphering_speed,
        starshipsDto.model,
        starshipsDto.name,
        starshipsDto.passengers,
        starshipsDto.pilots,
        starshipsDto.starship_class,
        starshipsDto.url,
        starshipsDto.id,
        starshipsDto.isFavourite
    )

    fun mapStarsShipsItemToDto(starshipsItem: ShipItem) = StarsShipsDto(
        starshipsItem.MGLT,
        starshipsItem.cargo_capacity,
        starshipsItem.consumables,
        starshipsItem.cost_in_credits,
        starshipsItem.created,
        starshipsItem.crew,
        starshipsItem.edited,
        starshipsItem.films,
        starshipsItem.hyperdrive_rating,
        starshipsItem.length,
        starshipsItem.manufacturer,
        starshipsItem.max_atmosphering_speed,
        starshipsItem.model,
        starshipsItem.name,
        starshipsItem.passengers,
        starshipsItem.pilots,
        starshipsItem.starship_class,
        starshipsItem.url,
        starshipsItem.id,
        starshipsItem.isFavorite
    )

}
