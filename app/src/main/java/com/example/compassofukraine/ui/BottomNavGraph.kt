package com.example.compassofukraine.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compassofukraine.ui.fragments.EventsPage
import com.example.compassofukraine.ui.fragments.ExcursionsPage
import com.example.compassofukraine.ui.fragments.HomePage
import com.example.compassofukraine.ui.fragments.PlacesPage
import com.example.compassofukraine.ui.fragments.ProfilePage

@Composable
fun BottomNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = BottomBarMenu.Home.route) {
        composable(route = BottomBarMenu.Home.route) {
            HomePage()
        }
        composable(route = BottomBarMenu.Events.route) {
            EventsPage()
        }
        composable(route = BottomBarMenu.Places.route) {
            PlacesPage()
        }
        composable(route = BottomBarMenu.Excursions.route) {
            ExcursionsPage()
        }
        composable(route = BottomBarMenu.Profile.route) {
            ProfilePage()
        }
    }
}
