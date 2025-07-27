package com.adriandeseta.cv.ui.adriandeseta.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.theme.cv_dark_grey

@Composable
fun SplashMiddle(navController: NavController) {
    Box(
        modifier = Modifier
            .background(cv_dark_grey)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var displaced by remember { mutableStateOf(false) }

        val displacement by animateFloatAsState(
            targetValue = if (displaced) -83f else 0f,
            animationSpec = tween(600, easing = LinearEasing),
            label = "Size",
            finishedListener = { navController.navigate(SplashScreens.SplashEnd.route) })

        Image(
            painter = painterResource(R.drawable.cv_splash),
            modifier = Modifier
                .offset(x = displacement.dp)
                .size(125.dp) // mismo ancho y alto para que quede perfectamente circular
                .clip(CircleShape)
                .background(Color.LightGray), // opcional, fondo detrás de la imagen
            contentScale = ContentScale.Crop,
            contentDescription = "Adrian De Seta CV"
        )

        LaunchedEffect(Unit) {
            displaced = !displaced
        }
    }
}