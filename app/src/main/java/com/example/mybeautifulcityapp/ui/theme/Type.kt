package com.example.mybeautifulcityapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mybeautifulcityapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Calistogar,
        fontSize = 42.sp,
        letterSpacing = 0.8.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = Calistogar,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = SenSemiBold,
        fontSize = 22.sp
    ),
    bodySmall = TextStyle(
        fontFamily = SenRegular,
        fontSize = 18.sp
    ),
    labelLarge = TextStyle(
        fontFamily = SenSemiBold,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = SenRegular,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = SenRegular,
        fontSize = 13.sp
    )
)