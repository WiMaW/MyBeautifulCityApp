package com.example.mybeautifulcityapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Place (
    @StringRes val nameResource: Int,
    @StringRes val descriptionResource: Int,
    @StringRes val localizationResource: Int,
    @DrawableRes val placeImageResource: Int,
    @DrawableRes val placeImageVintageResource: Int,
    @StringRes val placeCategory: Int
)




