package com.example.compassofukraine.util

import com.example.compassofukraine.R

sealed class BottomBarMenu(
    val route: String,
    val title: String,
    val iconActive: Int,
    val iconInactive: Int
) {
    object Home : BottomBarMenu(
        route = "home",
        title = "Home",
        iconActive = R.drawable.ic_home_active,
        iconInactive = R.drawable.ic_home_inactive
    )

    object Events : BottomBarMenu(
        route = "events",
        title = "Events",
        iconActive = R.drawable.ic_events_active,
        iconInactive = R.drawable.ic_events_inactive
    )

    object Places : BottomBarMenu(
        route = "places",
        title = "Places",
        iconActive = R.drawable.ic_places_active,
        iconInactive = R.drawable.ic_places_inactive
    )

    object Excursions : BottomBarMenu(
        route = "excursions",
        title = "Excursions",
        iconActive = R.drawable.ic_excursions_active,
        iconInactive = R.drawable.ic_excursions_inactive
    )

    object Profile : BottomBarMenu(
        route = "profile",
        title = "Profile",
        iconActive = R.drawable.ic_profile_active,
        iconInactive = R.drawable.ic_profile_inactive
    )
}
