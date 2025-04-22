package com.epiclabs.thinktok.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.epiclabs.thinktok.designsystem.R

val LatoFontFamily =
    FontFamily(
        Font(R.font.lato_light, FontWeight.Light),
        Font(R.font.lato_regular, FontWeight.Normal),
        Font(R.font.lato_regular, FontWeight.Medium),
        Font(R.font.lato_bold, FontWeight.SemiBold),
        Font(R.font.lato_bold, FontWeight.Bold),
    )
val Typography =
    Typography(
        bodyMedium =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
        titleSmall =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
        titleMedium =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
        headlineMedium =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                lineHeight = 36.sp,
                letterSpacing = 0.sp,
            ),
        labelLarge =
            TextStyle(
                fontFamily = LatoFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
            ),
    )
