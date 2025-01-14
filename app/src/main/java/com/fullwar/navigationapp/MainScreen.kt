package com.fullwar.navigationapp

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fullwar.navigationapp.include.SimpleLightTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    Scaffold (
        topBar = { SimpleLightTopAppBar("Nested Navigation") },
        bottomBar = { BottomBar(navController) }
    ){
        paddingValues -> var modifier = Modifier.padding(paddingValues)
        MainNavGraph(navController)
    }
}

@Composable
fun BottomBar(navController: NavController) {

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                AddItem(screen, currentDestination, navController)
            }
        }
    }
}

@Composable
fun RowScope.AddItem(screen: BottomBarScreen, currentDestination: NavDestination?, navController: NavController) {
    NavigationBarItem(
        label = {
            Text(
                text = screen.route
            )
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "image"
            )
        },
        selected = currentDestination?.hierarchy?.any{ it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
