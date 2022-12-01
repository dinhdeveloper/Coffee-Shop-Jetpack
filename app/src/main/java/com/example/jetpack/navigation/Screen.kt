package com.example.jetpack.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Menu : Screen("menu")
    object Search : Screen("search")
    object Hear : Screen("hear")
    object Profile : Screen("profile")
    object ProductDetailScreen : Screen("product_detail")
}