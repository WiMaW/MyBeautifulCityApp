package com.example.mybeautifulcityapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.core.view.WindowCompat
import com.example.mybeautifulcityapp.R

private val lightColorsTheme = lightColorScheme(
    primary = md_theme_light_primary, //yellow
    secondary = md_theme_light_secondary,//violet
    tertiary = md_theme_light_tertiary, //green


    primaryContainer = md_theme_light_primaryContainer, //white
    onPrimaryContainer = md_theme_light_onPrimaryContainer,

    outline = md_theme_light_outline,
    outlineVariant = md_theme_light_outlineVariant,
    surface = md_theme_light_surface, //green
)


private val darkColorsTheme = darkColorScheme(
    primary = md_theme_dark_primary,
    secondary = md_theme_dark_secondary,
    tertiary = md_theme_dark_tertiary,

    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,

    outline = md_theme_dark_outline,
    outlineVariant = md_theme_dark_outlineVariant,

    surface = md_theme_dark_surface,
)

val Calistogar = FontFamily(Font(R.font.calistogar_regular))
val SenRegular = FontFamily(Font(R.font.sen_regular))
val SenSemiBold = FontFamily(Font(R.font.sen_semibold))

@Composable
fun MyBeautifulCityAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkColorsTheme
        else -> lightColorsTheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}