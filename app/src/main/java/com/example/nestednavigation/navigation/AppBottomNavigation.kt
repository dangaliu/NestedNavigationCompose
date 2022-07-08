package com.example.nestednavigation.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNavigation(
    navController: NavHostController
) {
    val items = listOf<BottomNavItem>(
        BottomNavItem.Home,
        BottomNavItem.Settings,
        BottomNavItem.Profile
    )

    BottomNavigation(
        backgroundColor = Color.Blue
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState().value
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Yellow,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }

                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}