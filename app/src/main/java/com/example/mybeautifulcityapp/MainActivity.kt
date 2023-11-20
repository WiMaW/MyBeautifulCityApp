package com.example.mybeautifulcityapp

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mybeautifulcityapp.ui.MyBeautifulCityApp
import com.example.mybeautifulcityapp.ui.theme.MyBeautifulCityAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyBeautifulCityAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    Navigation(
                        windowSize = windowSize,
                        onBackPressed = {finish()}
                    )
                }
            }
        }
    }
}

@Composable
fun Navigation(
    windowSize: WindowSizeClass,
    onBackPressed: () -> Unit
) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable(route = "splash_screen") {
            SplashScreen(navController = navController)
        }
        composable(route = "main_screen") {
            MyBeautifulCityApp(
                onBackPressed = onBackPressed,
                windowSize = windowSize.widthSizeClass
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {Animatable(0f)}

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(1f).getInterpolation(it)
                }
            )
        )
        delay(3500L)
        navController.navigate("main_screen")
    }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.city_name),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 8.dp
            )
        )
        Image(
            painter = painterResource(R.drawable.city_hall),
            contentDescription = null,
            modifier = Modifier
                .scale(scale.value)
                .padding(bottom = 10.dp, top = 10.dp)
        )
        Text(
            text = stringResource(id = R.string.splash_screen_p1),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                horizontal = 20.dp,
                vertical = 8.dp
                )
                .scale(scale.value)
        )
        Text(
            text = stringResource(id = R.string.splash_screen_p2),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .scale(scale.value)
        )
    }
}


