package com.example.compassofukraine.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.compassofukraine.ui.screen.DetailedEventScreen
import com.example.compassofukraine.ui.screen.EventsScreen
import com.example.compassofukraine.ui.screen.ExcursionScreen
import com.example.compassofukraine.ui.screen.StubScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarMenu.Events.route) {
        composable(route = BottomBarMenu.Home.route) {
            StubScreen()
        }
        navigation(startDestination = "eventsList", route = BottomBarMenu.Events.route) {
            composable(route = "eventsList") {
                EventsScreen {
                    navHostController.navigate("event/$it")
                }
            }
            composable(route = "event/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
                it.arguments?.let {
                    DetailedEventScreen(it.getInt("id"))
                }
            }
        }
        composable(route = BottomBarMenu.Hotspots.route) {
            StubScreen()
        }
        composable(route = BottomBarMenu.Excursions.route) {
            ExcursionScreen()
        }
        composable(route = BottomBarMenu.Profile.route) {
            StubScreen()
        }
    }
}
