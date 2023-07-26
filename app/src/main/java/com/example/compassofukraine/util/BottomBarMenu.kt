package com.example.compassofukraine.util

import com.example.compassofukraine.R

sealed class BottomBarMenu(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarMenu(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home
    )

    object Events : BottomBarMenu(
        route = "events",
        title = "Events",
        icon = R.drawable.ic_events
    )

    object Hotspots : BottomBarMenu(
        route = "hotspots",
        title = "Hotspots",
        icon = R.drawable.ic_hotspots
    )

    object Excursions : BottomBarMenu(
        route = "excursions",
        title = "Excursions",
        icon = R.drawable.ic_excursions
    )

    object Profile : BottomBarMenu(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_profile
    )
}
