package com.example.compassofukraine.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compassofukraine.ui.fragments.NavigationPage

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarMenu.Home.route) {
        composable(route = BottomBarMenu.Home.route) {
            NavigationPage()
        }
        composable(route = BottomBarMenu.Events.route) {
            NavigationPage()
        }
        composable(route = BottomBarMenu.Places.route) {
            NavigationPage()
        }
        composable(route = BottomBarMenu.Excursions.route) {
            NavigationPage()
        }
        composable(route = BottomBarMenu.Profile.route) {
            NavigationPage()
        }
    }
}
