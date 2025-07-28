package com.adriandeseta.cv.ui.adriandeseta.skills

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.ui.adriandeseta.skills.dto.SkillsItemDto
import com.adriandeseta.cv.ui.main.resources.BoldText

@Composable
fun SkillsScreen(modifier: Modifier, navController: NavController) {
    val skills = listOf(
        SkillsItemDto("Kotlin", 4),
        SkillsItemDto("Jetpack Compose", 4),
        SkillsItemDto("POO", 4),
        SkillsItemDto("RESTful API", 4),
        SkillsItemDto("Solid", 4),
        SkillsItemDto("MVVM", 4),
        SkillsItemDto("Java", 3),
        SkillsItemDto("Scrum", 4),
        SkillsItemDto("HTML", 5),
        SkillsItemDto("CSS", 5),
        SkillsItemDto("GIT", 4),
        SkillsItemDto("JavaScript", 3),
        SkillsItemDto("Boostrap", 4),
        SkillsItemDto("Figma", 3),
        SkillsItemDto("User experience", 3),
        SkillsItemDto("Comunicación y gestion", 4)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        BoldText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = "Habilidades & Formación",
            fontSize = 62.sp
        )
        Spacer(Modifier.height(20.dp))

        skills.forEach { item ->
            SkillsItem(
                item.skill,
                rating = item.rating,
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