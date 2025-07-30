package com.adriandeseta.cv.ui.adriandeseta.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.main.resources.BoldText
import com.adriandeseta.cv.ui.main.resources.CustomText

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BoldText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.profile_title),
            fontSize = 62.sp
        )

        HorizontalDivider(
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        CustomText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "About",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(Modifier.height(10.dp))

        CustomText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = stringResource(R.string.profile_bio),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(Modifier.height(10.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                alignment = Alignment.CenterStart,
                painter = painterResource(R.drawable.cv_home_pic),
                contentDescription = stringResource(R.string.content_description),
                modifier = Modifier
                    .width(198.dp)
                    .height(220.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    // Si tenés un tema custom, usalo acá:
    MaterialTheme {
        // Usamos un NavController de prueba
        ProfileScreen()
    }
}