package com.fullwar.navigationapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    data object Home : BottomBarScreen("Home", "Home", Icons.Default.Home)
    data object Profile : BottomBarScreen("Profile", "Profile", Icons.Default.Person)
    data object Settings : BottomBarScreen("settings", "Settings", Icons.Default.Settings)
}