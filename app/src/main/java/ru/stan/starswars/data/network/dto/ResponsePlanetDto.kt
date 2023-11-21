package ru.stan.starswars.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponsePlanetDto(
    @Json(name = "count")
    val count: Int,
    @Json(name = "next")
    val next: String,
    @Json(name = "previous")
    val previous: String?,
    @Json(name = "results")
    val results: List<PlanetDto>
)