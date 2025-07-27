package com.adriandeseta.cv.ui.adriandeseta.experience

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ExperienceItem(
    modifier: Modifier = Modifier,
    period: String,
    company: String,
    role: String,
    responsibilities: List<String>,
) {
    Column(
        modifier = modifier.width(150.dp).height(200.dp).padding(8.dp)
    ) {
        Text(
            text = period,
            style = MaterialTheme.typography.labelMedium
        )

        Text(
            text = company,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = role,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontStyle = FontStyle.Italic
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        responsibilities.forEach { item ->
            Text(
                text = "• $item",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp)
            )
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