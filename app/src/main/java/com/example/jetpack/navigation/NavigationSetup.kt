package com.example.jetpack.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpack.ui.screen.home.HomeScreenContent
import com.example.jetpack.ui.screen.product_detail.ProductDetailScreen
import com.example.jetpack.ui.screen.profile.ProfileScreen
import com.example.jetpack.utils.ShareViewModel

@Composable
fun NavigationSetup(
    navController: NavHostController,
    bottomBarState: MutableState<Boolean>,
) {
    val shareViewModel: ShareViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            bottomBarState.value = true
            HomeScreenContent(shareViewModel, navController)
        }
        composable(Screen.Profile.route) {
            bottomBarState.value = true
            ProfileScreen(shareViewModel)
        }
        composable(Screen.ProductDetailScreen.route) {
            bottomBarState.value = false
            ProductDetailScreen(shareViewModel)
        }
    }
}