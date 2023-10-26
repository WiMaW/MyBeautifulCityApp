package com.example.mybeautifulcityapp.ui

import androidx.lifecycle.ViewModel
import com.example.mybeautifulcityapp.data.PlacesDataSource
import com.example.mybeautifulcityapp.model.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyBeautifulCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MyBeautifulCityUiState(
        placesList = PlacesDataSource.loadPlaces(),
        currentPlace = PlacesDataSource.loadPlaces().getOrElse(0) {
            PlacesDataSource.defaultPlace
        }
    ))

    val uiState: StateFlow <MyBeautifulCityUiState> = _uiState

    fun updateCurrentPlace(selectedPlace: Place) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

data class MyBeautifulCityUiState (
    val placesList: List<Place> = emptyList(),
    val currentPlace: Place = PlacesDataSource.defaultPlace,
    val isShowingListPage: Boolean = true
)

