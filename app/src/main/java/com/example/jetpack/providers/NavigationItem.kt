package com.example.jetpack.providers

import com.example.jetpack.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Music : NavigationItem("music", R.drawable.ic_list_order, "Menu")
    object Movies : NavigationItem("movies", R.drawable.ic_search_1, "Search")
    object Books : NavigationItem("books", R.drawable.ic_heart, "Hear")
    object Profile : NavigationItem("profile", R.drawable.ic_profile, "Profile")
}