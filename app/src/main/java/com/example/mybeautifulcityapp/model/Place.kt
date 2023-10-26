package com.example.mybeautifulcityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place (
    val id: Int,
    @StringRes val nameResource: Int,
    @StringRes val descriptionResource: Int,
    @StringRes val localizationResource: Int,
    @DrawableRes val placeImageResource: Int,
    val placeCategory: placeCategory
)

enum class placeCategory {
    History, Entertainment, Art, Shops, Food, Nature
}

