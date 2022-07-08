package com.example.nestednavigation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Home: BottomNavItem("Home", Icons.Default.Home, "home")
    object Settings: BottomNavItem("Settings", Icons.Default.Settings, "settings")
    object Profile: BottomNavItem("Profile", Icons.Default.Person, "profile")
}