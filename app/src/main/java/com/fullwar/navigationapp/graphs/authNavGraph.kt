package com.fullwar.navigationapp.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.SPLASH.route
    ){
        composable(route = AuthScreen.SPLASH.route){
            SplashScreen(navController)
        }
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.SignUp.route){
            SignUpScreen(navController)
        }
        composable(route = AuthScreen.Forgot.route){
            ForgotScreen(navController)
        }
    }
}

sealed class AuthScreen(val route: String) {
    data object SPLASH : AuthScreen("SPLASH")
    data object Login : AuthScreen("LOGIN")
    data object SignUp : AuthScreen("SIGN_UP")
    data object Forgot : AuthScreen("FORGOT")
}