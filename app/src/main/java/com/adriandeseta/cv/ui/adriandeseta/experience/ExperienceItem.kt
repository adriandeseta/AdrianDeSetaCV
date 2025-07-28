package com.adriandeseta.cv.ui.adriandeseta.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriandeseta.cv.ui.main.resources.CustomText
import com.adriandeseta.cv.ui.theme.cv_text_grey

@Composable
fun ExperienceItem(
    modifier: Modifier = Modifier,
    period: String,
    company: String,
    role: String,
    responsibilities: List<String>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        HorizontalDivider(color = Color.Black)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = company,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            CustomText(
                text = period,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = cv_text_grey
            )

        }

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Column {
                CustomText(
                    modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    text = role,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = cv_text_grey
                )

                Spacer(modifier = Modifier.height(4.dp))

                responsibilities.forEach { item ->
                    CustomText(
                        modifier.fillMaxWidth().padding(start = 8.dp),
                        textAlign = TextAlign.End,
                        text = item,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = cv_text_grey,
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewExperienceItem() {
    MaterialTheme {
        ExperienceItem(
            period = "2014 - 2020",
            company = "Lagash",
            role = "Sr. UI Developer",
            responsibilities = listOf("Tenaris", "Claro video", "Banco Santander")
        )
    }
}