package com.adriandeseta.cv.ui.main

sealed class MainScreens(val route: String) {

    data object SplashNavigation: MainScreens("splash_navigation")

    data object Home: MainScreens("home")

    data object Profile: MainScreens("profile")

    data object Skills: MainScreens("skills")

    data object PersonalData: MainScreens("personal_data")

    data object Experience: MainScreens("experience")

}