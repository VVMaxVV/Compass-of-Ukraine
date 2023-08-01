package com.example.compassofukraine.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.compassofukraine.ui.screen.EventsScreen
import com.example.compassofukraine.ui.screen.ExcursionListScreen
import com.example.compassofukraine.ui.screen.StubScreen
import com.example.compassofukraine.ui.screen.event.DetailedEventScreen
import com.example.compassofukraine.ui.screen.excursion.ExcursionDetailScreen
import com.example.compassofukraine.util.BottomBarMenu

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
        navigation(startDestination = "excursionList", route = BottomBarMenu.Excursions.route) {
            composable(route = "excursionList") {
                ExcursionListScreen {
                    navHostController.navigate("excursion/$it")
                }
            }
            composable(route = "excursion/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
                it.arguments?.let {
                    ExcursionDetailScreen(it.getInt("id"))
                }
            }
        }
        composable(route = BottomBarMenu.Profile.route) {
            StubScreen()
        }
    }
}
