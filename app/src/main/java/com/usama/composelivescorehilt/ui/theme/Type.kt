package com.usama.composelivescorehilt.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.usama.composelivescorehilt.R

//// Set of Material typography styles to start with
//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    ),
//    titleLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 22.sp,
//        lineHeight = 28.sp,
//        letterSpacing = 0.sp
//    ),
//    labelSmall = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Medium,
//        fontSize = 11.sp,
//        lineHeight = 16.sp,
//        letterSpacing = 0.5.sp
//    ),
//)






object Nunito {
    val Light = Font(R.font.nunito_light, FontWeight.W300)
    val Regular = Font(R.font.nunito_regular, FontWeight.W400)
    val Medium = Font(R.font.nunito_medium, FontWeight.W500)
    val Bold = Font(R.font.nunito_bold, FontWeight.W600)
}

private val NunitoFontFamily =
    FontFamily(listOf(Nunito.Light, Nunito.Regular, Nunito.Medium, Nunito.Bold))

val LiveScoreAppTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    titleMedium = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp
    ),
     labelLarge = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 18.sp
    ),
    labelMedium = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    ),
    labelSmall = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    displaySmall = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = NunitoFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
    ),
//    body1 = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//    body2 = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontSize = 14.sp
//    ),
//    button = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontWeight = FontWeight.W400,
//        fontSize = 15.sp,
//        color = Color.White
//    ),
//    caption = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 12.sp
//    ),
//    overline = TextStyle(
//        fontFamily = NunitoFontFamily,
//        fontWeight = FontWeight.W400,
//        fontSize = 12.sp
//    )
)
