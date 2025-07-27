package com.adriandeseta.cv.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adriandeseta.cv.ui.adriandeseta.HomeScreen
import com.adriandeseta.cv.ui.adriandeseta.splash.SplashNavigation

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = MainScreens.SplashNavigation.route){

        composable(MainScreens.SplashNavigation.route) {
            SplashNavigation(navController = navController)
        }

        composable(MainScreens.Home.route) {
            HomeScreen(navController = navController)
        }

    }

}