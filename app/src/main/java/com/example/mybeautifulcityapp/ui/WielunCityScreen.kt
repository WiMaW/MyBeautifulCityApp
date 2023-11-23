package com.example.mybeautifulcityapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybeautifulcityapp.R
import com.example.mybeautifulcityapp.model.Place
import com.example.mybeautifulcityapp.ui.theme.MyBeautifulCityAppTheme
import com.example.mybeautifulcityapp.ui.theme.Shapes
import com.example.mybeautifulcityapp.utilis.PlacesContentType

@Composable
fun MyBeautifulCityApp(
    onBackPressed: () -> Unit,
    windowSize: WindowWidthSizeClass,
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
            windowSize = windowSize)
    }
    ) { innerPadding ->
            if (contentType == PlacesContentType.LIST_AND_DETAIL) {
                PlaceListAndDetail(
                    places = uiState.placesList,
                    onClick = {viewModel.updateCurrentPlace(it)},
                    selectedPlace = uiState.currentPlace,
                    contentPadding = innerPadding,
                    onBackPressed = onBackPressed,
                    modifier = Modifier
                        .fillMaxSize()
                )
            } else {
                if (uiState.isShowingListPage) {
                    PlaceListLazyColumn(
                        places = uiState.placesList,
                        onClick = {
                            viewModel.updateCurrentPlace(it)
                            viewModel.navigateToDetailPage()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            ,
                        contentPadding = innerPadding
                    )
                } else {
                    Box(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)) {
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 65.dp, bottom = 15.dp, start = 10.dp, end = 10.dp),
                            elevation = CardDefaults.cardElevation(6.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                            shape = Shapes.large,
                        ) {
                            PlaceDetail(
                                selectedPlace = uiState.currentPlace,
                                onBackPressed = { viewModel.navigateToListPage() },
                                contentPadding = innerPadding,
                                modifier = Modifier,
                                imageHeight = 320,
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
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
                text =
                    if (isShowingDetailPage) {
                        selectedPlace.placeCategory.toString()
                    } else stringResource(R.string.app_bar),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.secondary
                )},
        navigationIcon = if (isShowingDetailPage) {
        {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button),
                    tint = MaterialTheme.colorScheme.outline
                    )
            }
        }} else {
            { Box () {}
            }
                },
        modifier = modifier.background(MaterialTheme.colorScheme.surface)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceListItem(
    place: Place,
    onClick: (Place) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = Shapes.large,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .width(400.dp)
            .height(120.dp)
            .border(4.dp, color = MaterialTheme.colorScheme.primary, Shapes.large),
        onClick = {onClick(place)}
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .clip(Shapes.large)
        ) {
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(2f)
                    .padding(18.dp)
            ) {
                Text(
                    text = stringResource(place.nameResource),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
                Divider(modifier = Modifier.height(2.dp))
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
                modifier = Modifier
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
            painter = painterResource(place.placeImageVintageResource),
            contentDescription = stringResource(place.nameResource),
            alignment = Alignment.Center,
            //modifier = Modifier.clip(CircleShape),
            contentScale = contentScale
        )
    }
}

@Composable
fun PlaceListLazyColumn(
    modifier: Modifier = Modifier,
    places: List<Place>,
    onClick: (Place) -> Unit,
    contentPadding: PaddingValues = PaddingValues(10.dp),
) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp)
    ) {
        items(places, //key = { place -> place.id }
            ) { place ->
            PlaceListItem(
                place = place,
                onClick = onClick,
            )
        }
    }
}

@Composable
fun PlaceDetailImage(
    selectedPlace: Place,
    contentScale: ContentScale,
    modifier: Modifier
    ) {
    Image(
        painter = painterResource(selectedPlace.placeImageResource),
        contentDescription = stringResource(selectedPlace.nameResource),
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
fun PlaceDetail(
    selectedPlace: Place,
    contentPadding: PaddingValues,
    onBackPressed: () -> Unit,
    imageHeight: Int,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    BackHandler {onBackPressed()}

    val scrollState = rememberScrollState()
    val layoutDirection = LocalLayoutDirection.current

    Box(
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(
                    bottom = 10.dp,
                    start = contentPadding.calculateStartPadding(layoutDirection),
                    end = contentPadding.calculateEndPadding(layoutDirection)
                )
        ) {
            PlaceDetailImage(
                selectedPlace,
                modifier = Modifier.height(imageHeight.dp),
                contentScale = contentScale
                )
                Text(
                    text = stringResource(selectedPlace.nameResource),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(15.dp)
                )
                Divider(modifier = Modifier
                    .height(3.dp)
                    .padding(horizontal = 15.dp)
                )
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
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(15.dp)
                )
        }
    }
}

@Composable
fun PlaceListAndDetail(
    modifier: Modifier = Modifier,
    places: List<Place>,
    onClick: (Place) -> Unit,
    selectedPlace: Place,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp),
){
    Row (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Box (modifier = Modifier
            .padding(top = 35.dp)
            .fillMaxWidth()
            .weight(3f)
        ){
            PlaceListLazyColumn(
                places = places,
                onClick = onClick
            )
        }
        Card (modifier = Modifier
            .weight(4f)
            .fillMaxSize()
            .padding(top = 65.dp, bottom = 25.dp, end = 20.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = Shapes.large,
        ){
            PlaceDetail(
                selectedPlace = selectedPlace,
                contentPadding = contentPadding,
                onBackPressed = onBackPressed,
                modifier = Modifier,
                imageHeight = 215,
                contentScale = ContentScale.Crop
            )
        }
    }
}

//@Composable
//@Preview(showBackground = true, device = Devices.TABLET)
//fun ListAndDetailPreview() {
//    MyBeautifulCityAppTheme {
//        PlaceListAndDetail(
//            places =
//            CoroutineScope().launch {
//                PlacesDataSource.loadPlaces()
//            }
//            onClick = {},
//            selectedPlace = PlacesDataSource.defaultPlace,
//            onBackPressed = {}
//        )
//    }
//}

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


