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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.adriandeseta.skills.dto.SkillsItemDto
import com.adriandeseta.cv.ui.main.resources.BoldText

@Composable
fun SkillsScreen(modifier: Modifier, navController: NavController) {
    val skills = listOf(
        SkillsItemDto(stringResource(R.string.skills_title_kotlin), 4),
        SkillsItemDto(stringResource(R.string.skills_title_jetpack), 4),
        SkillsItemDto(stringResource(R.string.skills_title_poo), 4),
        SkillsItemDto(stringResource(R.string.skills_title_restful), 4),
        SkillsItemDto(stringResource(R.string.skills_title_solid), 4),
        SkillsItemDto(stringResource(R.string.skills_title_mvvm), 4),
        SkillsItemDto(stringResource(R.string.skills_title_java), 3),
        SkillsItemDto(stringResource(R.string.skills_title_scrum), 4),
        SkillsItemDto(stringResource(R.string.skills_title_html), 5),
        SkillsItemDto(stringResource(R.string.skills_title_css), 5),
        SkillsItemDto(stringResource(R.string.skills_title_git), 4),
        SkillsItemDto(stringResource(R.string.skills_title_javascript), 3),
        SkillsItemDto(stringResource(R.string.skills_title_boostrap), 4),
        SkillsItemDto(stringResource(R.string.skills_title_figma), 3),
        SkillsItemDto(stringResource(R.string.skills_title_ux), 3),
        SkillsItemDto(stringResource(R.string.skills_title_comunicacion), 4)
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
            text = stringResource(R.string.skills_title),
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