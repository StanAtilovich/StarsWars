package ru.stan.starswars.data.room.mapper

import ru.stan.starswars.data.room.entity.ItemDbModel
import ru.stan.starswars.domain.model.FavoriteItem
import ru.stan.starswars.domain.model.PeopleItem
import ru.stan.starswars.domain.model.PlanetItem
import ru.stan.starswars.domain.model.ShipItem
import javax.inject.Inject


class MapperDbModel @Inject constructor() {
    fun mapPeopleToDbModel(peopleItem: PeopleItem) =
        ItemDbModel(
            id = peopleItem.id,
            name = peopleItem.name,
            field2 = peopleItem.gender,
            field3 = peopleItem.birth_year,
            isFavourite = peopleItem.isFavorite,
            type = PEOPLE_TYPE
        )

    fun mapDbModelToPeopleItem(itemDbModel: ItemDbModel) =
        PeopleItem(
            id = itemDbModel.id,
            name = itemDbModel.name,
            gender = itemDbModel.field2,
            birth_year = itemDbModel.field3,
            isFavorite = itemDbModel.isFavourite
        )

    fun mapPlanetToDbModel(planetItem: PlanetItem) =
        ItemDbModel(
            id = planetItem.id,
            name = planetItem.name,
            field2 = planetItem.diameter,
            field3 = planetItem.population,
            isFavourite = planetItem.isFavorite,
            type = PLANET_TYPE
        )
    fun mapDbModelToPlanetItem(itemDbModel: ItemDbModel) =
        PlanetItem(
            id = itemDbModel.id,
            name = itemDbModel.name,
            diameter = itemDbModel.field2,
            population = itemDbModel.field3,
            isFavorite = itemDbModel.isFavourite
        )

    fun mapShipToDbModel(shipItem: ShipItem) =
        ItemDbModel(
            id = shipItem.id,
            name = shipItem.name,
            field2 = shipItem.model,
            field3 = shipItem.length,
            isFavourite = shipItem.isFavorite,
            type = SHIP_TYPE
        )

    fun mapDbModelToShipItem(itemDbModel: ItemDbModel)=
        ShipItem(
            id = itemDbModel.id,
            name = itemDbModel.name,
            model = itemDbModel.field2,
            length = itemDbModel.field3,
            isFavorite = itemDbModel.isFavourite
        )

    fun mapItemDbToFavouriteItem(itemDbModel: ItemDbModel)=
        FavoriteItem(
            id = itemDbModel.id,
            name = itemDbModel.name,
            field2 = itemDbModel.field2,
            field3 = itemDbModel.field3,
            isFavourite = itemDbModel.isFavourite,
            type = itemDbModel.type
        )
    fun mapItemDbToFavouriteItem_list(items: List<ItemDbModel>) =
        items.map {
            mapItemDbToFavouriteItem(it)
        }

    companion object {
        const val PEOPLE_TYPE = "people"
        const val PLANET_TYPE = "planet"
        const val SHIP_TYPE = "ship"
    }
}
