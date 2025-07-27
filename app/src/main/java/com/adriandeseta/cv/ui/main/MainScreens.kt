package com.adriandeseta.cv.ui.main

sealed class MainScreens(val route: String) {

    data object SplashNavigation: MainScreens("splash_navigation")

    data object Home: MainScreens("home")

}