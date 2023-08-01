package com.example.compassofukraine.util

import com.example.compassofukraine.R

sealed class BottomBarMenu(
    val route: String,
    val titleId: Int,
    val icon: Int
) {
    object Home : BottomBarMenu(
        route = "home",
        titleId = R.string.bottom_bar_home_title,
        icon = R.drawable.ic_home
    )

    object Events : BottomBarMenu(
        route = "events",
        titleId = R.string.bottom_bar_events_title,
        icon = R.drawable.ic_events
    )

    object Hotspots : BottomBarMenu(
        route = "hotspots",
        titleId = R.string.bottom_bar_hotspots_title,
        icon = R.drawable.ic_hotspots
    )

    object Excursions : BottomBarMenu(
        route = "excursions",
        titleId = R.string.bottom_bar_excursions_title,
        icon = R.drawable.ic_excursions
    )

    object Profile : BottomBarMenu(
        route = "profile",
        titleId = R.string.bottom_bar_profile_title,
        icon = R.drawable.ic_profile
    )
}
