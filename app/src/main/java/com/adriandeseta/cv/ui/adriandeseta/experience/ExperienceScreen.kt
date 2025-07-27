package com.adriandeseta.cv.ui.adriandeseta.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.ui.adriandeseta.experience.dto.ExperienceData

@Composable
fun ExperienceScreen(navController: NavController) {
    val experiences = listOf(
        ExperienceData(
            period = "2014 - 2020",
            company = "Lagash",
            role = "Sr. UI Developer",
            responsibilities = listOf("Tenaris", "Claro video", "Banco Santander")
        ),
        ExperienceData(
            period = "2020 - 2023",
            company = "Otra empresa",
            role = "Android Developer",
            responsibilities = listOf("Proyecto X", "Proyecto Y")
        ),
        ExperienceData(
            period = "2023 - Presente",
            company = "Empresa Z",
            role = "Mobile Lead",
            responsibilities = listOf("Proyecto A", "Proyecto B")
        ),
        ExperienceData(
            period = "2021 - 2022",
            company = "Empresa W",
            role = "UI/UX Consultant",
            responsibilities = listOf("Proyecto C", "Proyecto D")
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Adrián De Seta - CV",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.secondary),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(experiences) { exp ->
                ExperienceItem(
                    modifier = Modifier,
                    period = exp.period,
                    company = exp.company,
                    role = exp.role,
                    responsibilities = exp.responsibilities
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewExperienceScreen() {
    MaterialTheme {
        ExperienceScreen(navController = rememberNavController())
    }
}