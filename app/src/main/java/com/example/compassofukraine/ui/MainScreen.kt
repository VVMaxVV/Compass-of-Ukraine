package com.example.compassofukraine.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navHostController = navHostController)
        }
    ) {
        Modifier.padding(it).wrapContentSize()
        BottomNavGraph(navHostController = navHostController)
    }
}

@Composable
fun BottomNavigationBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarMenu.Home,
        BottomBarMenu.Events,
        BottomBarMenu.Places,
        BottomBarMenu.Excursions,
        BottomBarMenu.Profile
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarMenu,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    BottomNavigationItem(
        selected = selected,
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = if (selected) screen.icon_active else screen.icon_inactive
                ),
                contentDescription = screen.title
            )
        },
        selectedContentColor = Color(0xFFFFD700),
        unselectedContentColor = Color(0xFF9B9B9B),
        alwaysShowLabel = false,
        modifier = Modifier.background(color = Color.White).defaultMinSize(minHeight = 100.dp),
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
