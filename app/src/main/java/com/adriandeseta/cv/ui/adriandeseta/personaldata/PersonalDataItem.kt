package com.adriandeseta.cv.ui.adriandeseta.personaldata

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriandeseta.cv.ui.main.resources.CustomText
import com.adriandeseta.cv.ui.theme.cv_text_grey

@Composable
fun PersonalDataItem(
    title: String,
    data: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        HorizontalDivider(color = Color.Black)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = data,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = cv_text_grey
            )

        }
    }
}

@Composable
fun PersonalDataItemLink(
    title: String,
    data: String,
    url:String
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        HorizontalDivider(color = Color.Black)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = data,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                },
                color = cv_text_grey,
                textDecoration = TextDecoration.Underline
            )
        }
    }
}