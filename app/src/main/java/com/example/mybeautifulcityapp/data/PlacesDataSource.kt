package com.example.mybeautifulcityapp.data

import com.example.mybeautifulcityapp.R
import com.example.mybeautifulcityapp.model.Place
import com.example.mybeautifulcityapp.model.PlaceCategory

object PlacesDataSource {
    val defaultPlace = loadPlaces()[0]

fun loadPlaces(): List<Place> {
    return listOf(
        Place(id = 1, R.string.city_hall, R.string.city_hall_description, R.string.city_hall_localization,R.drawable.city_hall, PlaceCategory.History),
        Place(id = 2, R.string.city_square, R.string.city_square_description,R.string.city_square_localization, R.drawable.plac_legionow, PlaceCategory.Entertainment),
        Place(id = 3, R.string.former_castle, R.string.former_castle_description, R.string.former_castle_localization, R.drawable.former_castle, PlaceCategory.History),
        Place(id = 4, R.string.eternal_love_statue, R.string.eternal_love_statue_description, R.string.eternal_love_statue_localization, R.drawable.eternal_love_statue, PlaceCategory.Art),
        Place(id = 5, R.string.saint_michael_church, R.string.saint_michael_church_description, R.string.saint_michael_church_localization, R.drawable.saint_michael_church, PlaceCategory.History),
        Place(id = 6, R.string.defensive_walls, R.string.defensive_walls_description, R.string.defensive_walls_localization, R.drawable.defensive_walls, PlaceCategory.History),
        Place(id = 7, R.string.city_park, R.string.city_park_description, R.string.city_park_localization, R.drawable.park_center, PlaceCategory.Nature),
        Place(id = 8, R.string.museum, R.string.museum_description, R.string.museum_localization, R.drawable.museum, PlaceCategory.History),
        Place(id = 9, R.string.kaliska_street, R.string.kaliska_street_description, R.string.kaliska_street_localization, R.drawable.kaliska_street, PlaceCategory.Shops),
        Place(id = 10, R.string.kaliska_gate, R.string.kaliska_gate_description, R.string.kaliska_gate_localization, R.drawable.kaliska_gate, PlaceCategory.History),
        Place(id = 11, R.string.library, R.string.library_description, R.string.library_localization, R.drawable.library, PlaceCategory.Entertainment),
        Place(id = 12, R.string.cinema, R.string.cinema_description, R.string.cinema_localization, R.drawable.cinema, PlaceCategory.Entertainment),
        Place(id = 13, R.string.park, R.string.park_description, R.string.park_localization, R.drawable.park, PlaceCategory.Nature)
    )
}
    fun loadPlacesPl(): List<Place> {
        return listOf(
            Place(id = 1, R.string.city_hall_pl, R.string.city_hall_description_pl, R.string.city_hall_localization,R.drawable.city_hall, PlaceCategory.History),
            Place(id = 2, R.string.city_square_pl, R.string.city_square_description_pl,R.string.city_square_localization, R.drawable.plac_legionow, PlaceCategory.Entertainment),
            Place(id = 3, R.string.former_castle_pl, R.string.former_castle_description_pl, R.string.former_castle_localization, R.drawable.former_castle, PlaceCategory.History),
            Place(id = 4, R.string.eternal_love_statue_pl, R.string.eternal_love_statue_description_pl, R.string.eternal_love_statue_localization, R.drawable.eternal_love_statue, PlaceCategory.Art),
            Place(id = 5, R.string.saint_michael_church_pl, R.string.saint_michael_church_description_pl, R.string.saint_michael_church_localization, R.drawable.saint_michael_church, PlaceCategory.History),
            Place(id = 6, R.string.defensive_walls_pl, R.string.defensive_walls_description_pl, R.string.defensive_walls_localization, R.drawable.defensive_walls, PlaceCategory.History),
            Place(id = 7, R.string.city_park_pl, R.string.city_park_description_pl, R.string.city_park_localization, R.drawable.park_center, PlaceCategory.Nature),
            Place(id = 8, R.string.museum_pl, R.string.museum_description_pl, R.string.museum_localization, R.drawable.museum, PlaceCategory.History),
            Place(id = 9, R.string.kaliska_street_pl, R.string.kaliska_street_description_pl, R.string.kaliska_street_localization, R.drawable.kaliska_street, PlaceCategory.Shops),
            Place(id = 10, R.string.kaliska_gate_pl, R.string.kaliska_gate_description_pl, R.string.kaliska_gate_localization, R.drawable.kaliska_gate, PlaceCategory.History),
            Place(id = 11, R.string.library_pl, R.string.library_description_pl, R.string.library_localization, R.drawable.library, PlaceCategory.Entertainment),
            Place(id = 12, R.string.cinema_pl, R.string.cinema_description_pl, R.string.cinema_localization, R.drawable.cinema, PlaceCategory.Entertainment),
            Place(id = 13, R.string.park_pl, R.string.park_description_pl, R.string.park_localization, R.drawable.park, PlaceCategory.Nature)
        )
    }
}