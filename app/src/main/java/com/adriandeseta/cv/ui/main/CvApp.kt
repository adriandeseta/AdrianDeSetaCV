package com.adriandeseta.cv.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.ui.theme.MyApplicationTheme

@Composable
fun CvApp() {

    MyApplicationTheme {
        val navController = rememberNavController()

        MainNavigation(navController)
    }
}