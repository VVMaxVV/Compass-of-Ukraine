package com.example.compassofukraine.ui.screen.excursion

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.compassofukraine.R
import com.example.compassofukraine.ui.theme.ButtonSelectedColor
import com.example.compassofukraine.ui.theme.ButtonUnselectedColor
import com.example.compassofukraine.util.ResultOf
import com.example.compassofukraine.util.map.toLatLng
import com.example.compassofukraine.util.ui.Carousel
import com.example.compassofukraine.util.ui.DetailedScreenSample
import com.example.compassofukraine.util.ui.ShowToast
import com.example.compassofukraine.util.ui.shimmerBrush
import com.example.compassofukraine.viewModel.excursion.ExcursionDetailViewModel
import com.example.model.ExcursionType
import com.example.model.excursion.DetailedExcursion
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import org.koin.androidx.compose.koinViewModel
import java.net.SocketTimeoutException

@Composable
internal fun ExcursionDetailScreen(id: Int) {
    val detailedExcursionViewModel =
        koinViewModel<ExcursionDetailViewModel>()
    val excursion by remember { detailedExcursionViewModel.excursion }
    val isFavoriteChecked by remember { detailedExcursionViewModel.isExcursionInFavorite }

    LaunchedEffect(Unit) {
        detailedExcursionViewModel.fetchExcursionDetails(id)
    }

    DetailedScreenSample(
        isFavorite = isFavoriteChecked,
        carouselContent = {
            Carousel(
                listUrl = (excursion as? ResultOf.Success<DetailedExcursion>)?.data?.imagesUrl
            )
        },
        bodyContent = { ExcursionDetailedContent(excursionDetailedResult = excursion) },
        onFavoriteClicked = { detailedExcursionViewModel.updateFavorite(id) }
    )
}

@Composable
fun ExcursionDetailedContent(excursionDetailedResult: ResultOf<DetailedExcursion>) {
    when (excursionDetailedResult) {
        is ResultOf.Success -> ExcursionDetailLoaded(excursionDetailedResult.data)

        is ResultOf.Loading -> ExcursionDetailLoading()

        is ResultOf.Error -> ExcursionDetailError(excursionDetailedResult.exception)
    }
}

@Composable
fun ExcursionDetailLoaded(excursion: DetailedExcursion) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            androidx.compose.material3.Text(
                text = excursion.name,
                style = MaterialTheme.typography.headlineMedium,
                maxLines = 3,
                modifier = Modifier.fillMaxWidth(.5f)
            )
        }
        Column(horizontalAlignment = Alignment.End) {
            androidx.compose.material3.Text(
                text = excursion.distance.toString() + stringResource(id = R.string.km),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
    androidx.compose.material3.Text(
        text = excursion.description,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
    )
    when (excursion.type) {
        ExcursionType.BICYCLE -> MapWithRoute(excursion.bicycleCoordinates.toLatLng())
        ExcursionType.WALKING -> MapWithRoute(excursion.walkingCoordinates.toLatLng())
        ExcursionType.CAR -> MapWithRoute(excursion.carCoordinates.toLatLng())
        ExcursionType.COMBINE -> ExcursionTypeBar(excursion)
    }
    Button(
        modifier = Modifier
            .padding(top = 20.dp, bottom = 10.dp)
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        onClick = {
        }
    ) {
        androidx.compose.material3.Text(text = stringResource(id = R.string.start_excursion))
    }
}

@Composable
fun ExcursionDetailLoading() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Column {
                androidx.compose.material3.Text(
                    text = "",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .background(Brush.shimmerBrush())
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                androidx.compose.material3.Text(
                    text = "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .background(Brush.shimmerBrush())
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(300.dp)
                .background(Brush.shimmerBrush())
        )
    }
}

@Composable
fun ExcursionDetailError(error: Exception) {
    when (error) {
        is SocketTimeoutException -> {
            ShowToast(message = stringResource(id = R.string.time_out_exception_toast))
        }

        else -> {
            ShowToast(message = stringResource(id = R.string.something_go_wrong_toast))
        }
    }
}

@Composable
fun MapWithRoute(points: List<LatLng>) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val map = MapView(context).apply {
                onCreate(null)
            }
            map
        }
    ) { mapView ->
        mapView.getMapAsync { googleMap ->
            val polylineOptions = PolylineOptions()
                .addAll(points)
                .color(android.graphics.Color.BLUE)
            googleMap.addPolyline(polylineOptions)
        }
    }
}

@Composable
private fun ExcursionTypeBar(excursion: DetailedExcursion) {
    val expandedButtonIndex = remember { mutableStateOf(1) }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ExcursionTypeButton(
                expandedButtonIndex,
                0,
                excursion.carTime.toString(),
                stringResource(id = R.string.car_icon)
            )
            ExcursionTypeButton(
                expandedButtonIndex,
                1,
                excursion.bicycleTime.toString(),
                stringResource(id = R.string.bicycle_icon)
            )
            ExcursionTypeButton(
                expandedButtonIndex,
                2,
                excursion.walkingTime.toString(),
                stringResource(id = R.string.walking_icon)
            )
        }
        // TODO("Teporary decicion, until we will receive map API key")

        when (expandedButtonIndex.value) {
            0 -> Image(
                painter = painterResource(id = R.drawable.mocked_car_map),
                contentDescription = "Card mocked map",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp)
                    .height(350.dp)
                    .width(350.dp)
            )

            1 -> {
                Image(
                    painter = painterResource(id = R.drawable.mocked_walking_map),
                    contentDescription = "Bicycle mocked map",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 10.dp)
                        .height(350.dp)
                        .width(350.dp)
                )
            }

            2 -> {
                Image(
                    painter = painterResource(id = R.drawable.mocked_car_map),
                    contentDescription = "Walking mocked map",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 10.dp)
                        .height(350.dp)
                        .width(350.dp)
                )
            }
        }
    }
}

@Composable
private fun ExcursionTypeButton(
    expandedButtonIndex: MutableState<Int>,
    buttonIndex: Int,
    buttonText: String,
    buttonIcon: String
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
        modifier = Modifier.padding(18.dp)
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = backgroundColor,
                    shape = Shapes().medium.copy(all = CornerSize(16.dp))
                )
                .height(120.dp)
                .width(animatedWidthDp)
                .clickable {
                    expandedButtonIndex.value = buttonIndex
                }
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()

            ) {
                Text(
                    text = buttonIcon,
                    style = TextStyle(color = Color.Black, fontSize = 28.sp),
                    modifier = Modifier.padding(6.dp)
                )
                if (isNeedExpansion.value) {
                    Text(
                        text = buttonText,
                        style = TextStyle(color = Color.Black, fontSize = 18.sp),
                        modifier = Modifier.padding(6.dp)
                    )
                }
            }
        }
    }
}
