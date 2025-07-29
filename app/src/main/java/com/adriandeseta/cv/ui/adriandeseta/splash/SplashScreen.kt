package com.adriandeseta.cv.ui.adriandeseta.splash

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.main.resources.CustomText
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val bgColor = remember { Animatable(Color.Black) }
    val contentAlpha = remember { Animatable(0f) }

    val textColor = if (bgColor.value.luminance() < 0.5f) Color.White else Color.Black

    LaunchedEffect(Unit) {
        delay(500)

        contentAlpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000)
        )

        delay(1000)

        bgColor.animateTo(
            targetValue = Color.White,
            animationSpec = tween(durationMillis = 1500)
        )

        delay(300)
        navController.navigate("main") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor.value)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.alpha(contentAlpha.value)
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cv_home_pic),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            CustomText(
                text = stringResource(R.string.personal_data_name),
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium,
                color = textColor
            )
            CustomText(
                text = stringResource(R.string.splash_sub_title),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = textColor
            )
        }
    }
}
