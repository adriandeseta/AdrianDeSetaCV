package com.adriandeseta.cv.ui.adriandeseta.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adriandeseta.cv.R
import kotlin.math.pow

@Composable
fun SplashStart(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var expanded by remember { mutableStateOf(false) }

        val screenWidth = LocalConfiguration.current.screenWidthDp.toFloat()
        val screenHeight = LocalConfiguration.current.screenHeightDp.toFloat()

        val maxRadius = (screenWidth.pow(2) + screenHeight.pow(2)).pow(0.5f) * 1.5f

        val radius by animateFloatAsState(
            targetValue = if (expanded) maxRadius else 132f,
            animationSpec = tween(700, delayMillis = 1800, LinearEasing),
            label = "Size",
            finishedListener = { navController.navigate(SplashScreens.SplashMiddle.route) })

        LaunchedEffect(Unit) {
            expanded = !expanded
        }

        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                drawCircle(
                    color = Color.Yellow,
                    radius = radius
                )
            })

        Image(
            painter = painterResource(R.drawable.cv_splash),
            contentDescription = "Adrian De Seta CV",
            modifier = Modifier
                .size(100.dp) // mismo ancho y alto para que quede perfectamente circular
                .clip(CircleShape)
                .background(Color.LightGray), // opcional, fondo detrás de la imagen
            contentScale = ContentScale.Crop // rellena el círculo
        )

    }
}