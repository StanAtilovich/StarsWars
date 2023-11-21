package ru.stan.starswars.domain.model

data class FavoriteItem(
    val id:String,
    val name:String,
    val field2:String,
    val field3:String,
    val isFavourite:Boolean,
    val type:String
)