package com.example.compassofukraine.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compassofukraine.ui.screen.EventsScreen
import com.example.compassofukraine.ui.screen.StubScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarMenu.Events.route) {
        composable(route = BottomBarMenu.Home.route) {
            StubScreen()
        }
        composable(route = BottomBarMenu.Events.route) {
            EventsScreen()
        }
        composable(route = BottomBarMenu.Places.route) {
            StubScreen()
        }
        composable(route = BottomBarMenu.Excursions.route) {
            StubScreen()
        }
        composable(route = BottomBarMenu.Profile.route) {
            StubScreen()
        }
    }
}
