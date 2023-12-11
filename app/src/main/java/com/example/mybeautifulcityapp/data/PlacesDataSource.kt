package com.example.mybeautifulcityapp.data

import com.example.mybeautifulcityapp.R
import com.example.mybeautifulcityapp.model.Place
import kotlinx.coroutines.runBlocking

object PlacesDataSource {

    val placeList: List<Place> = listOf(
        Place(
            R.string.city_hall,
            R.string.city_hall_description,
            R.string.city_hall_localization,
            R.drawable.city_hall,
            R.string.history
        ),
        Place(
            R.string.city_square,
            R.string.city_square_description,
            R.string.city_square_localization,
            R.drawable.plac_legionow,
            R.string.entertainment,
        ),
        Place(
            R.string.former_castle,
            R.string.former_castle_description,
            R.string.former_castle_localization,
            R.drawable.former_castle,
            R.string.history,
        ),
        Place(
            R.string.eternal_love_statue,
            R.string.eternal_love_statue_description,
            R.string.eternal_love_statue_localization,
            R.drawable.eternal_love_statue,
            R.string.art,
        ),
        Place(
            R.string.saint_michael_church,
            R.string.saint_michael_church_description,
            R.string.saint_michael_church_localization,
            R.drawable.saint_michael_church,
            R.string.history,
        ),
        Place(
            R.string.defensive_walls,
            R.string.defensive_walls_description,
            R.string.defensive_walls_localization,
            R.drawable.defensive_walls,
            R.string.history,
        ),
        Place(
            R.string.city_park,
            R.string.city_park_description,
            R.string.city_park_localization,
            R.drawable.park_center,
            R.string.nature,
        ),
        Place(
            R.string.museum,
            R.string.museum_description,
            R.string.museum_localization,
            R.drawable.museum,
            R.string.history,
        ),
        Place(
            R.string.kaliska_street,
            R.string.kaliska_street_description,
            R.string.kaliska_street_localization,
            R.drawable.kaliska_street,
            R.string.shops,
        ),
        Place(
            R.string.kaliska_gate,
            R.string.kaliska_gate_description,
            R.string.kaliska_gate_localization,
            R.drawable.kaliska_gate,
            R.string.history,
        ),
        Place(
            R.string.library,
            R.string.library_description,
            R.string.library_localization,
            R.drawable.library,
            R.string.entertainment,
        ),
        Place(
            R.string.cinema,
            R.string.cinema_description,
            R.string.cinema_localization,
            R.drawable.cinema,
            R.string.entertainment,
        ),
        Place(
            R.string.park,
            R.string.park_description,
            R.string.park_localization,
            R.drawable.park,
            R.string.nature,
        ),
        Place(
            R.string.jewish_cemetery,
            R.string.jewish_cemetery_description,
            R.string.jewish_cemetery_localization,
            R.drawable.cementary,
            R.string.history,
        )
    )

    val defaultPlace = placeList[0]
}