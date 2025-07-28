package com.adriandeseta.cv.ui.main.resources

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.adriandeseta.cv.R

private val figtreeBlack = Font(R.font.figtree_black, FontWeight.Black)
private val figtreeBold = Font(R.font.figtree_bold, FontWeight.Bold)
private val figtreeExtraBold = Font(R.font.figtree_extra_bold, FontWeight.ExtraBold)
private val figtreeLight = Font(R.font.figtree_light, FontWeight.Light)
private val figtreeMedium = Font(R.font.figtree_medium, FontWeight.Medium)
private val figtreeRegular = Font(R.font.figtree_regular, FontWeight.Normal)

// Familia de fuentes
val figtreeFontFamily = FontFamily(
    figtreeBlack,
    figtreeBold,
    figtreeExtraBold,
    figtreeLight,
    figtreeMedium,
    figtreeRegular
)

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    style: TextStyle = TextStyle.Default,
    textDecoration: TextDecoration = TextDecoration.None
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        textAlign = textAlign,
        fontFamily = figtreeFontFamily,
        fontWeight = fontWeight,
        style = style,
        textDecoration = textDecoration
    )
}
@Composable
fun CustomTextLink(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black,
    fontWeight: FontWeight = FontWeight.Normal,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        textAlign = textAlign,
        fontFamily = figtreeFontFamily,
        fontWeight = fontWeight,
        style = style
    )
}
// Versiones específicas (opcionales, para conveniencia)
@Composable
fun NormalText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black
) = CustomText(
    modifier = modifier,
    text = text,
    textAlign = textAlign,
    fontSize = fontSize,
    color = color,
    fontWeight = FontWeight.Normal
)

@Composable
fun BoldText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black
) = CustomText(
    modifier = modifier,
    text = text,
    textAlign = textAlign,
    fontSize = fontSize,
    color = color,
    fontWeight = FontWeight.Bold
)

@Composable
fun BlackText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = 16.sp,
    color: Color = Color.Black
) = CustomText(
    modifier = modifier,
    text = text,
    textAlign = textAlign,
    fontSize = fontSize,
    color = color,
    fontWeight = FontWeight.Black
)