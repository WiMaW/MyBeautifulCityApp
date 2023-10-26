package com.example.mybeautifulcityapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybeautifulcityapp.R
import com.example.mybeautifulcityapp.data.PlacesDataSource
import com.example.mybeautifulcityapp.model.Place
import com.example.mybeautifulcityapp.ui.theme.MyBeautifulCityAppTheme
import com.example.mybeautifulcityapp.utilis.PlacesContentType

@Composable
fun MyBeautifulCityApp(
    onBackPressed: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel: MyBeautifulCityViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val contentType = when(windowSize) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> PlacesContentType.LIST_ONLY
        WindowWidthSizeClass.Expanded -> PlacesContentType.LIST_AND_DETAIL
        else -> PlacesContentType.LIST_ONLY
    }

    Scaffold(
        topBar = {
        AppBar(
            onBackButtonClick = {viewModel.navigateToListPage()},
            isShowingListPage = uiState.isShowingListPage,
            selectedPlace = uiState.currentPlace,
            windowSize = windowSize
            )
    }
    ) { innerPadding ->
            if (contentType == PlacesContentType.LIST_AND_DETAIL) {
                PlaceListAndDetail(
                    places = uiState.placesList,
                    onClick = {viewModel.updateCurrentPlace(it)},
                    selectedPlace = uiState.currentPlace,
                    contentPadding = innerPadding,
                    onBackPressed = onBackPressed,
                    modifier = modifier
                        .fillMaxWidth()
                )
            } else {
                if (uiState.isShowingListPage) {
                    PlaceList(
                        places = uiState.placesList,
                        onClick = {
                            viewModel.updateCurrentPlace(it)
                            viewModel.navigateToDetailPage()
                        },
                        modifier = Modifier
                            .padding(horizontal = 6.dp)
                            .fillMaxWidth(),
                        contentPadding = innerPadding
                    )
                } else {
                    PlaceDetail(
                        selectedPlace = uiState.currentPlace,
                        onBackPressed = {viewModel.navigateToListPage()},
                        contentPadding = innerPadding,
                        modifier = modifier.fillMaxWidth()
                    )
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onBackButtonClick: () -> Unit,
    isShowingListPage: Boolean,
    selectedPlace: Place,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val isShowingDetailPage = windowSize != WindowWidthSizeClass.Expanded && !isShowingListPage

    TopAppBar(
        title = {
            Text(
                text = if (isShowingDetailPage) {
                    selectedPlace.placeCategory.toString()
                    } else {stringResource(R.string.app_bar)},
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
                )
                },
        navigationIcon = if (isShowingDetailPage) {
        {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button),
                    )
            }
        }} else {
            { Box {} }},
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceListItem(
    place: Place,
    onClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .width(400.dp)
            .height(120.dp),
        onClick = {onClick(place)}
    ) {
        Row (
            modifier = modifier.fillMaxWidth()
        ) {
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .weight(2f)
                    .padding(10.dp)
            ) {
                Text(
                    text = stringResource(place.nameResource),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
                Divider()
                Text(
                    text = stringResource(place.localizationResource),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            PlaceImageListItem(
                place = place,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .weight(1f)
            )
        }
    }
}

@Composable
fun PlaceImageListItem(
    place: Place,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(place.placeImageResource),
            contentDescription = stringResource(place.nameResource),
            alignment = Alignment.Center,
            contentScale = contentScale
        )
    }
}

@Composable
fun PlaceList(
    places: List<Place>,
    onClick: (Place) -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier.padding(vertical = 15.dp)
    ) {
        items(places, key = { place -> place.id }) { place ->
            PlaceListItem(
                place = place,
                onClick = onClick,
                modifier = modifier
            )
        }
    }
}

@Composable
fun PlaceDetail(
    selectedPlace: Place,
    contentPadding: PaddingValues,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {onBackPressed()}

    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current

    Box(
        modifier = modifier
            .padding(top = contentPadding.calculateTopPadding())
            .verticalScroll(scrollState)
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .padding(
                    bottom = contentPadding.calculateTopPadding(),
                    start = contentPadding.calculateStartPadding(layoutDirection),
                    end = contentPadding.calculateEndPadding(layoutDirection)
                )
        ) {
                Image(
                    painter = painterResource(selectedPlace.placeImageResource),
                    contentDescription = stringResource(selectedPlace.nameResource),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.height(380.dp)
                )
                Text(
                    text = stringResource(selectedPlace.nameResource),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(15.dp)
                )
                Divider()
                Text(
                    text = stringResource(selectedPlace.descriptionResource),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    text = "Localization: ${stringResource(selectedPlace.localizationResource)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(15.dp)
                )
        }
    }
}

@Composable
fun PlaceListAndDetail(
    places: List<Place>,
    onClick: (Place) -> Unit,
    selectedPlace: Place,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier.fillMaxWidth(),
    ) {
        Box (modifier = modifier
            .padding(top = 48.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .weight(2f)
        ){
            PlaceList(
                places = places,
                onClick = onClick,
                modifier = Modifier
            )
        }
        PlaceDetail(
            selectedPlace = selectedPlace,
            contentPadding = contentPadding,
            onBackPressed = onBackPressed,
            modifier = Modifier.weight(3f)
        )
    }
}

@Composable
@Preview(showBackground = true, device = Devices.TABLET)
fun ListAndDetailPreview() {
    MyBeautifulCityAppTheme {
        PlaceListAndDetail(
            places = PlacesDataSource.loadPlaces(),
            onClick = {},
            selectedPlace = PlacesDataSource.defaultPlace,
            onBackPressed = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AppPreview() {
    MyBeautifulCityAppTheme {
        MyBeautifulCityApp(
            onBackPressed = {},
            windowSize = WindowWidthSizeClass.Medium
        )
    }
}


