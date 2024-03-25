package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

//NEED TO IMPORT ALL FONTS - they should be in one of the other folders!
private val appFontKarla = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.karla_regular,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.karla_medium,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.karla_bold,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        ),
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
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold,
        color = LittleLemonColor.charcoal,
        fontFamily = appFontMark
    ),
    headlineMedium = TextStyle(
        color = LittleLemonColor.charcoal,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = appFontMark
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
