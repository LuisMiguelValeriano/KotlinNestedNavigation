package com.fullwar.navigationapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RootNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT
    ) {
        authNavGraph(navController = navController)
        composable(route = Graph.MAIN_SCREEN_PAGE){
            MainScreenPage()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val MAIN_SCREEN_PAGE = "main_screen_graph"
    const val DETAILS = "details_graph"
}