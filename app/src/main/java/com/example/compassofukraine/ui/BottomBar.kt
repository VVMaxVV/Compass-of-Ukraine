package com.example.compassofukraine.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compassofukraine.util.BottomBarMenu

@Composable
fun BottomBar(navHostController: NavHostController) {
    val screens = listOf(
        BottomBarMenu.Home,
        BottomBarMenu.Events,
        BottomBarMenu.Places,
        BottomBarMenu.Excursions,
        BottomBarMenu.Profile
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var isBottomBarVisible by remember { mutableStateOf(true) }

    if (isBottomBarVisible) {
        BottomNavigation(
            backgroundColor = Color.White,
            modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navHostController = navHostController
                )
            }
        }
    }

    navHostController.addOnDestinationChangedListener { _, destination, _ ->
        isBottomBarVisible = when (destination.route) {
            "event/{id}" -> false
            else -> true
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
            Text(
                text = screen.title,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
        },
        selectedContentColor = MaterialTheme.colorScheme.primary,
        unselectedContentColor = MaterialTheme.colorScheme.secondary,
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = if (selected) screen.iconActive else screen.iconInactive
                ),
                contentDescription = screen.title
            )
        },
        alwaysShowLabel = true,
        modifier = Modifier.background(color = Color.Transparent),
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
