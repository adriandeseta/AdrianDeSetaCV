package com.adriandeseta.cv.ui.adriandeseta.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.main.MainScreens
import com.adriandeseta.cv.ui.theme.cv_dark_grey
import kotlinx.coroutines.delay

@Composable
fun SplashEnd(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(cv_dark_grey),
        contentAlignment = Alignment.Center
    ) {
        var expanded by remember { mutableStateOf(false) }
        var animationFinished by remember { mutableStateOf(false) }

        val expansion by animateFloatAsState(
            targetValue = if (expanded) 1f else 0.30f,
            animationSpec = tween(500, easing = LinearEasing),
            label = "Size",
            finishedListener = {
                animationFinished = true
            }
        )

        LaunchedEffect(Unit) {
            expanded = true
        }

        LaunchedEffect(animationFinished) {
            if (animationFinished) {
                delay(1000L)
                navController.popBackStack()
                navController.navigate(MainScreens.Home.route)
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.cv_splash),
                modifier = Modifier
                    .size(125.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop,
                contentDescription = "Adrian De Seta CV"
            )
            Text(
                text = "Adrian De Seta CV",
                modifier = Modifier.padding(start = 10.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
