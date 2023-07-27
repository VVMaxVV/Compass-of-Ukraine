package com.example.compassofukraine.util.map

import com.example.model.GeoPosition
import com.google.android.gms.maps.model.LatLng

fun List<GeoPosition>.toLatLng(): List<LatLng> {
    return this.map { LatLng(it.latitude, it.longitude) }
}
