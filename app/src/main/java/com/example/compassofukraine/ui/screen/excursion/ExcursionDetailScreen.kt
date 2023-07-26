package com.example.compassofukraine.ui.screen.excursion

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.compassofukraine.ui.theme.ButtonSelectedColor
import com.example.compassofukraine.ui.theme.ButtonUnselectedColor
import com.example.compassofukraine.viewModel.excursion.ExcursionDetailViewModel
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
internal fun ExcursionDetailScreen() {
    val viewModel = koinViewModel<ExcursionDetailViewModel>()
    val isLoaded by rememberSaveable { viewModel.isLoaded }

    var uiSettings by remember { mutableStateOf(MapUiSettings()) }
    var properties by remember {
        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
    ) {
        ExcursionTypeBar()

        MapWithRoute()
    }
}

@Composable
fun MapWithRoute() {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val map = MapView(context).apply {
                onCreate(null)
            }
            map
        },
    ) { mapView ->
        mapView.getMapAsync { googleMap ->
            // Set up the map settings, markers, etc.

            // Define the list of coordinates (LatLng) for the route points.
            val points = listOf(
                LatLng(37.7749, -122.4194), // Origin
                LatLng(37.3352, -121.8811), // Waypoint 1
                LatLng(38.5816, -121.4944), // Waypoint 2
                LatLng(37.7749, -122.4194), // Destination
            )

            // Draw the polyline on the map.
            val polylineOptions = PolylineOptions()
                .addAll(points)
                .color(android.graphics.Color.BLUE)
            googleMap.addPolyline(polylineOptions)
        }
    }
}

@Composable
private fun ExcursionTypeBar() {
    val expandedButtonIndex = remember { mutableStateOf(-1) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ExcursionTypeButton(expandedButtonIndex, 0, "Button 1", "\uD83D\uDE97")
        ExcursionTypeButton(expandedButtonIndex, 1, "Button 2", "\uD83D\uDE97")
        ExcursionTypeButton(expandedButtonIndex, 2, "Button 3", "\uD83D\uDE97")
    }
}

@Composable
private fun ExcursionTypeButton(
    expandedButtonIndex: MutableState<Int>,
    buttonIndex: Int,
    buttonText: String,
    buttonIcon: String,
) {
    val isExpanded = expandedButtonIndex.value == buttonIndex
    val isNeedExpansion = remember { mutableStateOf(false) }

    LaunchedEffect(isExpanded) {
        if (isExpanded && !isNeedExpansion.value) {
            isNeedExpansion.value = true
        } else if (!isExpanded && isNeedExpansion.value) {
            isNeedExpansion.value = false
        }
    }

    val animatedWidthDp: Dp by animateDpAsState(targetValue = if (isNeedExpansion.value) 140.dp else 80.dp)
    val backgroundColor: Color by animateColorAsState(targetValue = if (isNeedExpansion.value) ButtonSelectedColor else ButtonUnselectedColor)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(18.dp),
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = backgroundColor,
                    shape = Shapes().medium.copy(all = CornerSize(16.dp)),
                )
                .height(150.dp).width(animatedWidthDp).clickable {
                    expandedButtonIndex.value = buttonIndex
                },
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),

            ) {
                Text(
                    text = buttonIcon,
                    style = TextStyle(color = Color.Black, fontSize = 28.sp),
                    modifier = Modifier.padding(16.dp),
                )
                if (isNeedExpansion.value) {
                    Text(
                        text = buttonText,
                        style = TextStyle(color = Color.Black, fontSize = 18.sp),
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}
