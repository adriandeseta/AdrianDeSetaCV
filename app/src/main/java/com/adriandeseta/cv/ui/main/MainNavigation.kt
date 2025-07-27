package com.adriandeseta.cv.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adriandeseta.cv.ui.adriandeseta.HomeScreen
import com.adriandeseta.cv.ui.adriandeseta.experience.ExperienceScreen
import com.adriandeseta.cv.ui.adriandeseta.personaldata.PersonalDataScreen
import com.adriandeseta.cv.ui.adriandeseta.profile.ProfileScreen
import com.adriandeseta.cv.ui.adriandeseta.skills.SkillsScreen
import com.adriandeseta.cv.ui.adriandeseta.splash.SplashNavigation

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = MainScreens.SplashNavigation.route) {

        composable(MainScreens.SplashNavigation.route) {
            SplashNavigation(navController = navController)
        }

        composable(MainScreens.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(MainScreens.Profile.route) {
            ProfileScreen(navController = navController)
        }

        composable(MainScreens.Skills.route) {
            SkillsScreen(navController = navController)
        }

        composable(MainScreens.Experience.route) {
            ExperienceScreen(navController = navController)
        }

        composable(MainScreens.PersonalData.route) {
            PersonalDataScreen(navController = navController)
        }
    }

}