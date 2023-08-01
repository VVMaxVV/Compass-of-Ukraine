package com.example.compassofukraine.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
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
        BottomBarMenu.Hotspots,
        BottomBarMenu.Excursions,
        BottomBarMenu.Profile
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var isBottomBarVisible by remember { mutableStateOf(true) }

    if (isBottomBarVisible) {
        NavigationBar(
            modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
            containerColor = MaterialTheme.colorScheme.surface,
            tonalElevation = 0.dp
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
            "event/{id}", "excursion/{id}" -> false
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

    NavigationBarItem(
        selected = selected,
        label = {
            Text(
                text = stringResource(id = screen.titleId),
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
        },
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(
                    id = screen.icon
                ),
                contentDescription = stringResource(id = screen.titleId)
            )
        },
        alwaysShowLabel = true,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
            selectedTextColor = MaterialTheme.colorScheme.onSurface,
            unselectedIconColor = MaterialTheme.colorScheme.onSurface,
            unselectedTextColor = MaterialTheme.colorScheme.onSurface,
            indicatorColor = MaterialTheme.colorScheme.primary
        )
    )
}
