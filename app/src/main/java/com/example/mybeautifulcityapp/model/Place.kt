package com.example.mybeautifulcityapp.model

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mybeautifulcityapp.R

data class Place (
    @StringRes val nameResource: Int,
    @StringRes val descriptionResource: Int,
    @StringRes val localizationResource: Int,
    @DrawableRes val placeImageResource: Int,
    @DrawableRes val placeImageVintageResource: Int,
    val placeCategory: PlaceCategory,
)

enum class PlaceCategory(stringResource: Int) {
    History(R.string.history),
    Entertainment(R.string.entertainment),
    Art(R.string.art),
    Shops(R.string.shops),
    Food(R.string.food),
    Nature(R.string.nature)
}


