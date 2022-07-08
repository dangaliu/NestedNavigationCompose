package com.example.nestednavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nestednavigation.navigation.AppBottomNavigation
import com.example.nestednavigation.navigation.Navigation
import com.example.nestednavigation.ui.theme.NestedNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NestedNavigationTheme {
                App()
            }
        }
    }

    @Composable
    fun App() {
        val navController = rememberNavController()
        val bottomItems = listOf<String>("main", "home", "settings", "profile")
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                if (navController.currentBackStackEntryAsState().value?.destination?.route in bottomItems) {
                    AppBottomNavigation(navController = navController)
                }
            }
        ) {
            Navigation(
                navController = navController
            )
        }
    }
}

