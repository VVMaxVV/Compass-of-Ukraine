package com.example.compassofukraine.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.rememberMotionLayoutState
import com.example.compassofukraine.R
import com.example.compassofukraine.ui.theme.CompassOfUkraineTheme
import com.example.compassofukraine.util.ResultOf
import com.example.compassofukraine.util.openMapWithDirections
import com.example.compassofukraine.util.ui.Carousel
import com.example.compassofukraine.util.ui.DragIndicator
import com.example.compassofukraine.util.ui.FavoriteButton
import com.example.compassofukraine.util.ui.ShowToast
import com.example.compassofukraine.util.ui.shimmerBrush
import com.example.compassofukraine.viewModel.DetailedEventViewModel
import com.example.model.DetailedEvent
import com.example.model.EventTime
import org.koin.androidx.compose.koinViewModel
import java.net.SocketTimeoutException

@OptIn(ExperimentalMotionApi::class)
@Composable
fun DetailedEventScreen(id: Int) {
    val motionLayoutState = rememberMotionLayoutState()
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.event_details).readBytes().decodeToString()
    }
    val detailedEventViewModel =
        koinViewModel<DetailedEventViewModel>()
    val event by remember { detailedEventViewModel.event }
    val isFavoriteChecked by remember { detailedEventViewModel.isEventInFavorite }

    LaunchedEffect(Unit) {
        detailedEventViewModel.fetchEventDetails(id)
    }

    MotionLayout(
        motionScene = MotionScene(motionScene),
        motionLayoutState = motionLayoutState,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .fillMaxHeight()
    ) {
        Carousel(
            listUrl = (event as? ResultOf.Success<DetailedEvent>)?.data?.imagesUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .layoutId("carousel")
        )
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
                .layoutId("container_details")
        ) {
            Column(Modifier.padding(bottom = 88.dp)) {
                Box(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 28.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    DragIndicator()
                }
                DetailedEventSheet(detailedEventResult = event)
            }
        }
        Box(modifier = Modifier.layoutId("button_favorite")) {
            if (event is ResultOf.Success) {
                FavoriteButton(isFavoriteChecked) {
                    if (motionLayoutState.currentProgress != 1f) {
                        detailedEventViewModel.updateFavorite(id)
                    }
                }
            }
        }
        Button(modifier = Modifier.layoutId("button_open_map"), onClick = {
            (event as? ResultOf.Success)?.let {
                it.data.apply {
                    openMapWithDirections(context, coordinates.latitude, coordinates.longitude)
                }
            }
        }) {
            Text(text = stringResource(id = R.string.show_on_the_map))
        }
    }
}

@Composable
fun DetailedEventSheet(detailedEventResult: ResultOf<DetailedEvent>) {
    when (detailedEventResult) {
        is ResultOf.Success -> {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    detailedEventResult.data.let { event ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column {
                                Text(
                                    text = event.title,
                                    style = MaterialTheme.typography.headlineMedium,
                                    maxLines = 3,
                                    modifier = Modifier.fillMaxWidth(.5f)
                                )
                                Text(
                                    text = event.shortDescription,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    text = "${event.dateStart.dayOfMonth}.${event.dateStart.month.value}.${event.dateStart.year}",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                                Text(
                                    text = when (event.eventTime) {
                                        is EventTime.AllDay -> stringResource(id = R.string.all_day_label)
                                        is EventTime.Time -> "${(event.eventTime as EventTime.Time).start} - ${(event.eventTime as EventTime.Time).finish}"
                                    },
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                        }
                        Text(
                            text = event.description,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
                        )
                    }
                }
            }
        }

        is ResultOf.Loading -> {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column {
                        Text(
                            text = "",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .fillMaxWidth(.5f)
                                .background(Brush.shimmerBrush())
                        )
                        Text(
                            text = "",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier
                                .fillMaxWidth(.25f)
                                .background(Brush.shimmerBrush())
                        )
                    }
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth(.5f)
                                .background(Brush.shimmerBrush())
                        )
                        Text(
                            text = "",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier
                                .fillMaxWidth(.25f)
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

        is ResultOf.Error -> {
            when (detailedEventResult.exception) {
                is SocketTimeoutException -> {
                    ShowToast(message = stringResource(id = R.string.time_out_exception_toast))
                }
                else -> {
                    ShowToast(message = stringResource(id = R.string.something_go_wrong_toast))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyMotionLayoutPreview() {
    CompassOfUkraineTheme {
        DetailedEventScreen(id = 1)
    }
}
