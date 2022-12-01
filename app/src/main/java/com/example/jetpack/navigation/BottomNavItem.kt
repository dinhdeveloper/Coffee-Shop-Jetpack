package com.example.jetpack.navigation

import com.example.jetpack.R

sealed class BottomNavItem(var route: String, var icon: Int, var title: String) {
    object Home : BottomNavItem(Screen.Home.route, R.drawable.ic_home, "Home")
    object Menu : BottomNavItem(Screen.Menu.route, R.drawable.ic_list_order, "Menu")
    object Search : BottomNavItem(Screen.Search.route, R.drawable.ic_search_1, "Search")
    object Hear : BottomNavItem(Screen.Hear.route, R.drawable.ic_heart, "Hear")
    object Profile : BottomNavItem(Screen.Profile.route, R.drawable.ic_profile, "Profile")
}


//sealed class BottomNavItem(
//    val route: String,
//    @StringRes val titleResId: Int,
//    val icon: ImageVector
//) {
//    object Home : BottomNavItem(
//        route = Screen.Home.route,
//        titleResId = R.string.screen_title_home,
//        icon = Icons.Default.Home
//    )
//
//    object Settings : BottomNavItem(
//        route = Screen.Settings.route,
//        titleResId = R.string.screen_title_settings,
//        icon = Icons.Default.Settings
//    )
//}