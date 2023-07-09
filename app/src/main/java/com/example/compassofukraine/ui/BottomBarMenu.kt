package com.example.compassofukraine.ui

import com.example.compassofukraine.R

sealed class BottomBarMenu(
    val route: String,
    val title: String,
    val icon_active: Int,
    val icon_inactive: Int
) {
    object Home : BottomBarMenu(
        route = "home",
        title = "Home",
        icon_active = R.drawable.ic_home_active,
        icon_inactive = R.drawable.ic_home_inactive
    )

    object Events : BottomBarMenu(
        route = "events",
        title = "Events",
        icon_active = R.drawable.ic_events_active,
        icon_inactive = R.drawable.ic_events_inactive
    )

    object Places : BottomBarMenu(
        route = "places",
        title = "Places",
        icon_active = R.drawable.ic_places_active,
        icon_inactive = R.drawable.ic_places_inactive
    )

    object Excursions : BottomBarMenu(
        route = "excursions",
        title = "Excursions",
        icon_active = R.drawable.ic_excursions_active,
        icon_inactive = R.drawable.ic_excursions_inactive
    )

    object Profile : BottomBarMenu(
        route = "profile",
        title = "Profile",
        icon_active = R.drawable.ic_profile_active,
        icon_inactive = R.drawable.ic_profile_inactive
    )
}
