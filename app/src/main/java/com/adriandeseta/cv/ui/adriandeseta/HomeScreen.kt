package com.adriandeseta.cv.ui.adriandeseta

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título principal arriba
        Text(
            text = "Adrián De Seta - CV",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .padding(vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        // Espaciador flexible para centrar los botones en pantalla
        Spacer(modifier = Modifier.weight(1f))

        // Botones en dos filas
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SquareButton(
                    text = "PERFIL",
                    onClick = {navController.navigate("profile")}
                )
                SquareButton(
                    text = "EXPERIENCIA",
                    onClick = {navController.navigate("experience")}

                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SquareButton(
                    text = "HABILIDADES",
                    onClick = {navController.navigate("skills")}

                )
                SquareButton(
                    text = "INFORMACIÓN\nPERSONAL",
                    onClick = {navController.navigate("personal_data")}

                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun SquareButton(text: String, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .size(140.dp)
            .background(MaterialTheme.colorScheme.tertiary, shape = MaterialTheme.shapes.medium)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
}
