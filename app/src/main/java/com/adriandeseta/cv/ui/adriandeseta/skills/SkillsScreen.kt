package com.adriandeseta.cv.ui.adriandeseta.skills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SkillsScreen(modifier: Modifier, navController: NavController) {
    val skills = listOf(
        "KOTLIN",
        "JETPACK COMPOSE",
        "POO",
        "RESTful API",
        "SOLID",
        "MVVM",
        "JAVA",
        "SCRUM",
        "HTML",
        "CSS",
        "GIT",
        "JAVASCRIPT",
        "BOOSTRAP",
        "FIGMA",
        "USER EXPERIENCE",
        "COMUNICACION Y GESTION"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Adrián De Seta - CV",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(20.dp))

        Text(
            text = "Habilidades",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        skills.forEach { item ->
            Text(
                text = "• $item",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 8.dp),
                textAlign = TextAlign.Start
            )
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSkillsScreenScreen() {
    // Si tenés un tema custom, usalo acá:
    MaterialTheme {
        // Usamos un NavController de prueba
        SkillsScreen(
            navController = rememberNavController(),
            modifier = Modifier
        )
    }
}