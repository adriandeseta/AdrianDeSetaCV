package com.adriandeseta.cv.ui.adriandeseta.skills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adriandeseta.cv.ui.main.resources.CustomText

@Composable
fun SkillsItem(
    skill: String,
    rating: Int
) {
    val maxRating = 5

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp)
            .background(Color.White)
    ) {
        HorizontalDivider(color = Color.Black)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomText(
                text = skill,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Row(
                Modifier.padding(top = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                repeat(maxRating) { index ->
                    val color = if (index < rating) Color.Black else Color.LightGray
                    androidx.compose.foundation.Canvas(
                        modifier = Modifier
                            .height(12.dp)
                            .aspectRatio(1f),
                        onDraw = {
                            drawCircle(color)
                        }
                    )
                }
            }
        }
    }
}
