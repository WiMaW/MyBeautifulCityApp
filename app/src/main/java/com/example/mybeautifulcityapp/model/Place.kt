package com.example.mybeautifulcityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place (
    val id: Int,
    @StringRes val nameResource: Int,
    @StringRes val descriptionResource: Int,
    @StringRes val localizationResource: Int,
    @DrawableRes val placeImageResource: Int,
    val placeCategory: PlaceCategory
)

enum class PlaceCategory {
    History, Entertainment, Art, Shops, Food, Nature
}

