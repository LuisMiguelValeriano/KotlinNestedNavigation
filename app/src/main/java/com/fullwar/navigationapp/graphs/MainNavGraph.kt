package com.fullwar.navigationapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fullwar.navigationapp.BottomBarScreen

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        route = Graph.MAIN_SCREEN_PAGE
    ) {
        composable(route = BottomBarScreen.Home.route){
            ScreenContent(
                name = BottomBarScreen.Home.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }

        composable(route = BottomBarScreen.Profile.route){
            ScreenContent(
                name = BottomBarScreen.Profile.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }

        composable(route = BottomBarScreen.Settings.route){
            ScreenContent(
                name = BottomBarScreen.Settings.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )
        }

        detailsNavGraph(navController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        startDestination = DetailsScreen.DETAILS_PAGE.route,
        route = Graph.DETAILS
    ){
        composable(route = DetailsScreen.DETAILS_PAGE.route){
            ScreenContent(
                name = "Detail Page"
            ){
                navController.navigate(DetailsScreen.SUB_DETAILS_PAGE.route)
            }
        }
        composable(route = DetailsScreen.SUB_DETAILS_PAGE.route){
            ScreenContent(
                name = "Sub Detail Page"
            ){
                navController.navigate(DetailsScreen.SUB_DETAILS_PAGE.route)
            }
        }
    }
}

sealed class DetailsScreen(val route: String) {
    object DETAILS_PAGE : DetailsScreen("DETAILS_PAGE_")
    object SUB_DETAILS_PAGE : DetailsScreen("DETAILS_PAGE_SUB")
}
