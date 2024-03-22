package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

private val appFontKarla = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.karla_regular,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        )
    )
)

private val appFontMark = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.markazitext_regular,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        )
    )
)

//NEED to sort fonts!

val Typography = Typography(
    headlineLarge = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.charcoal,
        fontFamily = appFontKarla
    ),
    headlineMedium = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = appFontKarla
    ),
    bodyMedium = TextStyle(
        color = LittleLemonColor.green,
        fontFamily = appFontKarla
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.green,
        fontFamily = appFontKarla
    ),
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = appFontKarla
    )
)
