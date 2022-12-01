package com.example.jetpack.navigation

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpack.R
import com.example.jetpack.ui.theme.BrightRed
import com.example.jetpack.ui.theme.bgOgran

@Composable
fun BottomNavigationBar(
    navController: NavController,
    bottomBarState: MutableState<Boolean>,
    navBackStackEntry: NavBackStackEntry?
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Menu,
        BottomNavItem.Search,
        BottomNavItem.Hear,
        BottomNavItem.Profile
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content = {
            BottomNavigation(
                backgroundColor = colorResource(id = R.color.white),
                contentColor = Color.White
            ) {
                val currentRoute = navBackStackEntry?.destination?.route // man hinh hien tai

                items.forEach { item ->
                    BottomNavigationItem(
                        icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                        selectedContentColor = BrightRed.copy(0.4f),
                        unselectedContentColor = bgOgran.copy(0.7f),
                        modifier = Modifier
                            .width(22.dp)
                            .height(22.dp)
                            .padding(1.dp)
                            .offset(y = 13.dp)
                            .weight(1f),
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    )


}