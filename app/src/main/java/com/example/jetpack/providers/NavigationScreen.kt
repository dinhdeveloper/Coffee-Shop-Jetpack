package com.example.jetpack.providers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.ui.screen.MainScreen
import com.example.jetpack.ui.screen.profile.ProfileScreen
import com.example.jetpack.ui.theme.bgToolbar
import com.example.jetpack.utils.ShareViewModel

@Composable
fun NavigationScreen(
    onStatusBarColorChange: (color: Color) -> Unit
) {
    val navController = rememberNavController()
    val shareViewModel: ShareViewModel = hiltViewModel()
    Scaffold{ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = NavigationItem.Home.route
            ) {
                composable(route = NavigationItem.Home.route) {
                    onStatusBarColorChange(bgToolbar)
                    MainScreen()
                }
                composable(route = NavigationItem.Profile.route) {
                    onStatusBarColorChange(bgToolbar)
                    //ProfileScreen()
                }

            }
        }
    }
}