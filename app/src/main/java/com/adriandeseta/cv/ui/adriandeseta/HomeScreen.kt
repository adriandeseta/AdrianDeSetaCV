package com.adriandeseta.cv.ui.adriandeseta

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Text(
            text = "Resume",
            fontSize = 70.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    MaterialTheme {
        // Usamos un NavController de prueba
        HomeScreen(navController = rememberNavController())
    }
}