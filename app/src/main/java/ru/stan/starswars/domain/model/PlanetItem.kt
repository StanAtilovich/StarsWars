package ru.stan.starswars.domain.model

import java.util.UUID

data class PlanetItem(
    val climate: String = "",
    val created: String = "",
    val diameter: String,
    val edited: String = "",
    val films: List<String> = emptyList(),
    val gravity: String = "",
    val name: String,
    val orbital_period: String = "",
    val population: String,
    val residents: List<String> = emptyList(),
    val rotation_period: String = "",
    val surface_water: String = "",
    val terrain: String = "",
    val url: String = "",
    val id: String = UUID.randomUUID().toString(),
    val isFavorite: Boolean = false
)