package com.example.jetpack.ui.screen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpack.navigation.BottomNavigationBar
import com.example.jetpack.navigation.NavigationSetup

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val navBackStackEntry by navController.currentBackStackEntryAsState() // man hinh se quay ve

    Scaffold(
        bottomBar = { BottomNavigationBar(
            navController, bottomBarState, navBackStackEntry)
        }
    ) {
        NavigationSetup(
            navController = navController,
            bottomBarState
        )
    }
}

