package com.example.mybeautifulcityapp.data

import com.example.mybeautifulcityapp.R
import com.example.mybeautifulcityapp.model.Place
import com.example.mybeautifulcityapp.model.placeCategory

object PlacesDataSource {
    val defaultPlace = loadPlaces()[0]

fun loadPlaces(): List<Place> {
    return listOf(
        Place(id = 1, R.string.city_hall, R.string.city_hall_description, R.string.city_hall_localization,R.drawable.city_hall, placeCategory.History),
        Place(id = 2, R.string.former_castle, R.string.former_castle_description, R.string.former_castle_localization, R.drawable.former_castle, placeCategory.History),
        Place(id = 3, R.string.eternal_love_statue, R.string.eternal_love_statue_description, R.string.eternal_love_statue_localization, R.drawable.eternal_love_statue, placeCategory.Art),
        Place(id = 4, R.string.saint_michael_church, R.string.saint_michael_church_description, R.string.saint_michael_church_localization, R.drawable.saint_michael_church, placeCategory.History),
        Place(id = 5, R.string.defensive_walls, R.string.defensive_walls_description, R.string.defensive_walls_localization, R.drawable.defensive_walls, placeCategory.History),
        Place(id = 6, R.string.museum, R.string.museum_description, R.string.museum_localization, R.drawable.museum, placeCategory.History),
        Place(id = 7, R.string.cinema, R.string.cinema_description, R.string.cinema_localization, R.drawable.cinema, placeCategory.Entertainment),
        Place(id = 8, R.string.park, R.string.park_description, R.string.park_localization, R.drawable.park, placeCategory.Nature)
    )
}
}