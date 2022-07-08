package com.example.nestednavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nestednavigation.screens.MainScreen
import com.example.nestednavigation.screens.OnBoardingScreen
import com.example.nestednavigation.screens.SplashScreen
import com.example.nestednavigation.screens.bottomScreens.HomeScreen
import com.example.nestednavigation.screens.bottomScreens.ProfileScreen
import com.example.nestednavigation.screens.bottomScreens.SettingsScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavConstants.splash
    ) {
        composable(route = NavConstants.splash) {
            SplashScreen(navController = navController)
        }
        composable(route = NavConstants.onboarding) {
            OnBoardingScreen(navController = navController)
        }
        composable(route = NavConstants.main) {
            MainScreen(navController = navController)
        }
        composable(route = NavConstants.home) {
            HomeScreen(navController = navController)
        }
        composable(route = NavConstants.settings) {
            SettingsScreen(navController = navController)
        }
        composable(route = NavConstants.profile) {
            ProfileScreen(navController = navController)
        }
    }
}