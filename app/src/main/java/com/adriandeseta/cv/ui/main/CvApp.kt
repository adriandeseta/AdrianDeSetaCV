package com.adriandeseta.cv.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.adriandeseta.cv.R
import com.adriandeseta.cv.ui.adriandeseta.HomeScreen
import com.adriandeseta.cv.ui.adriandeseta.experience.ExperienceScreen
import com.adriandeseta.cv.ui.adriandeseta.personaldata.PersonalDataScreen
import com.adriandeseta.cv.ui.adriandeseta.profile.ProfileScreen
import com.adriandeseta.cv.ui.adriandeseta.skills.SkillsScreen
import com.adriandeseta.cv.ui.main.resources.CustomText
import kotlinx.coroutines.launch

@Composable
fun CvApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    BackHandler(enabled = drawerState.isOpen) {
        scope.launch { drawerState.close() }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                onDestinationClicked = { route ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                navController = navController,
                drawerState = drawerState
            )
        }
    ) {
        AppScaffold(
            title = stringResource(R.string.content_description),
            drawerState = drawerState,
            navController = navController
        ) { modifier ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = modifier
            ) {
                composable("home") { HomeScreen() }
                composable("perfil") { ProfileScreen() }
                composable("experiencia") { ExperienceScreen() }
                composable("habilidades") { SkillsScreen() }
                composable("informacion") { PersonalDataScreen() }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    drawerState: DrawerState,
    navController: NavHostController,
    content: @Composable (Modifier) -> Unit
) {
    val scope = rememberCoroutineScope()

    Scaffold(modifier = Modifier.padding(0.dp),
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.White,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.Black,
                    actionIconContentColor = Color.Black,
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomText(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.clickable {
                                navController.navigate("home") {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                        IconButton(
                            onClick = { scope.launch { drawerState.open() } }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menú")
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        content(
            Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        )
    }
}

@Composable
fun DrawerContent(
    drawerState: DrawerState,
    navController: NavHostController,
    onDestinationClicked: (String) -> Unit
) {
    val scope = rememberCoroutineScope()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomText(
                text = stringResource(R.string.content_description),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.clickable {
                    onDestinationClicked("home")
                }
            )
            IconButton(
                modifier = Modifier.offset(10.dp),
                onClick = {
                    scope.launch {
                        drawerState.close()
                    }
                }
            ) {
                Icon(Icons.Default.Close, contentDescription = "Close")
            }
        }
        Spacer(Modifier.height(20.dp))
        listOf(
            "perfil" to stringResource(R.string.menu_title_perfil),
            "experiencia" to stringResource(R.string.menu_title_experiencia),
            "habilidades" to stringResource(R.string.menu_title_habilidades),
            "informacion" to stringResource(R.string.menu_title_informacion_personal)
        ).forEach { (route, label) ->
            CustomText(
                text = label,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(if (currentRoute == route) Color.LightGray else Color.Transparent)
                    .fillMaxWidth()
                    .clickable { onDestinationClicked(route) }
                    .padding(top = 5.dp, bottom = 5.dp, start = 16.dp, end = 16.dp)
                    .height(60.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CvAppPreview() {
    MaterialTheme {
        CvApp()
    }
}

@Preview(showBackground = true)
@Composable
fun DrawerContentPreview() {
    val navController = rememberNavController()
    val drawerState = DrawerState(initialValue = DrawerValue.Closed)

    MaterialTheme {
        DrawerContent(
            drawerState = drawerState,
            navController = navController,
            onDestinationClicked = {}
        )
    }
}
