package com.example.mybeautifulcityapp.data

import com.example.mybeautifulcityapp.R
import com.example.mybeautifulcityapp.model.Place
import com.example.mybeautifulcityapp.model.PlaceCategory
import com.example.mybeautifulcityapp.model.PlaceCategoryPL

object PlacesDataSource {
    val defaultPlace = loadPlaces()[0]
    val defaultPlacePL = loadPlacesPl()[0]

fun loadPlaces(): List<Place> {
    return listOf(
        Place(id = 1, R.string.city_hall, R.string.city_hall_description, R.string.city_hall_localization,R.drawable.city_hall, PlaceCategory.History, null),
        Place(id = 2, R.string.city_square, R.string.city_square_description,R.string.city_square_localization, R.drawable.plac_legionow, PlaceCategory.Entertainment, null),
        Place(id = 3, R.string.former_castle, R.string.former_castle_description, R.string.former_castle_localization, R.drawable.former_castle, PlaceCategory.History, null),
        Place(id = 4, R.string.eternal_love_statue, R.string.eternal_love_statue_description, R.string.eternal_love_statue_localization, R.drawable.eternal_love_statue, PlaceCategory.Art, null),
        Place(id = 5, R.string.saint_michael_church, R.string.saint_michael_church_description, R.string.saint_michael_church_localization, R.drawable.saint_michael_church, PlaceCategory.History, null),
        Place(id = 6, R.string.defensive_walls, R.string.defensive_walls_description, R.string.defensive_walls_localization, R.drawable.defensive_walls, PlaceCategory.History, null),
        Place(id = 7, R.string.city_park, R.string.city_park_description, R.string.city_park_localization, R.drawable.park_center, PlaceCategory.Nature, null),
        Place(id = 8, R.string.museum, R.string.museum_description, R.string.museum_localization, R.drawable.museum, PlaceCategory.History, null),
        Place(id = 9, R.string.kaliska_street, R.string.kaliska_street_description, R.string.kaliska_street_localization, R.drawable.kaliska_street, PlaceCategory.Shops, null),
        Place(id = 10, R.string.kaliska_gate, R.string.kaliska_gate_description, R.string.kaliska_gate_localization, R.drawable.kaliska_gate, PlaceCategory.History, null),
        Place(id = 11, R.string.library, R.string.library_description, R.string.library_localization, R.drawable.library, PlaceCategory.Entertainment, null),
        Place(id = 12, R.string.cinema, R.string.cinema_description, R.string.cinema_localization, R.drawable.cinema, PlaceCategory.Entertainment, null),
        Place(id = 13, R.string.park, R.string.park_description, R.string.park_localization, R.drawable.park, PlaceCategory.Nature, null),
        Place(id = 14, R.string.jewish_cemetery, R.string.jewish_cemetery_description, R.string.jewish_cemetery_localization, R.drawable.cementary, PlaceCategory.History, null)
    )
}
    fun loadPlacesPl(): List<Place> {
        return listOf(
            Place(id = 1, R.string.city_hall_pl, R.string.city_hall_description_pl, R.string.city_hall_localization_pl,R.drawable.city_hall, null, PlaceCategoryPL.Historia),
            Place(id = 2, R.string.city_square_pl, R.string.city_square_description_pl,R.string.city_square_localization_pl, R.drawable.plac_legionow, null, PlaceCategoryPL.Rozrywka),
            Place(id = 3, R.string.former_castle_pl, R.string.former_castle_description_pl, R.string.former_castle_localization_pl, R.drawable.former_castle, null, PlaceCategoryPL.Historia),
            Place(id = 4, R.string.eternal_love_statue_pl, R.string.eternal_love_statue_description_pl, R.string.eternal_love_statue_localization_pl, R.drawable.eternal_love_statue, null, PlaceCategoryPL.Sztuka),
            Place(id = 5, R.string.saint_michael_church_pl, R.string.saint_michael_church_description_pl, R.string.saint_michael_church_localization_pl, R.drawable.saint_michael_church, null, PlaceCategoryPL.Historia),
            Place(id = 6, R.string.defensive_walls_pl, R.string.defensive_walls_description_pl, R.string.defensive_walls_localization_pl, R.drawable.defensive_walls, null, PlaceCategoryPL.Historia),
            Place(id = 7, R.string.city_park_pl, R.string.city_park_description_pl, R.string.city_park_localization_pl, R.drawable.park_center, null, PlaceCategoryPL.Natura),
            Place(id = 8, R.string.museum_pl, R.string.museum_description_pl, R.string.museum_localization_pl, R.drawable.museum, null, PlaceCategoryPL.Historia),
            Place(id = 9, R.string.kaliska_street_pl, R.string.kaliska_street_description_pl, R.string.kaliska_street_localization_pl, R.drawable.kaliska_street, null, PlaceCategoryPL.Zakupy),
            Place(id = 10, R.string.kaliska_gate_pl, R.string.kaliska_gate_description_pl, R.string.kaliska_gate_localization_pl, R.drawable.kaliska_gate, null, PlaceCategoryPL.Historia),
            Place(id = 11, R.string.library_pl, R.string.library_description_pl, R.string.library_localization_pl, R.drawable.library, null, PlaceCategoryPL.Rozrywka),
            Place(id = 12, R.string.cinema_pl, R.string.cinema_description_pl, R.string.cinema_localization_pl, R.drawable.cinema, null, PlaceCategoryPL.Rozrywka),
            Place(id = 13, R.string.park_pl, R.string.park_description_pl, R.string.park_localization_pl, R.drawable.park, null, PlaceCategoryPL.Natura),
            Place(id = 14, R.string.jewish_cemetery_pl, R.string.jewish_cemetery_description_pl, R.string.jewish_cemetery_localization_pl, R.drawable.cementary, null, PlaceCategoryPL.Historia)
        )
    }
}