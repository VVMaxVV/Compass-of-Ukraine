package com.example.compassofukraine.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.layoutId
import com.example.compassofukraine.R

@OptIn(ExperimentalMaterialApi::class, ExperimentalMotionApi::class)
@Composable
fun DetailedScreenSample(
    isFavorite: Boolean,
    carouselContent: @Composable () -> Unit,
    bodyContent: @Composable LazyItemScope.() -> Unit,
    actionButton: @Composable () -> Unit = {},
    onFavoriteClicked: () -> Unit
) {
    val swipingState = rememberSwipeableState(initialValue = SwipingStates.EXPANDED)
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.detailed_screen).readBytes().decodeToString()
    }

    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val heightInPx = with(LocalDensity.current) { maxHeight.toPx() }
        val nestedScrollConnection = remember {
            object : NestedScrollConnection {
                override fun onPreScroll(
                    available: Offset,
                    source: NestedScrollSource
                ): Offset {
                    val delta = available.y
                    return if (delta < 0) {
                        swipingState.performDrag(delta).toOffset()
                    } else {
                        Offset.Zero
                    }
                }

                override fun onPostScroll(
                    consumed: Offset,
                    available: Offset,
                    source: NestedScrollSource
                ): Offset {
                    val delta = available.y
                    return swipingState.performDrag(delta).toOffset()
                }

                override suspend fun onPostFling(
                    consumed: Velocity,
                    available: Velocity
                ): Velocity {
                    swipingState.performFling(velocity = available.y)
                    return super.onPostFling(consumed, available)
                }

                private fun Float.toOffset() = Offset(0f, this)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .swipeable(
                    state = swipingState,
                    thresholds = { _, _ ->
                        FractionalThreshold(.25f)
                    },
                    orientation = Orientation.Vertical,
                    anchors = mapOf(
                        0f to SwipingStates.COLLAPSED,
                        heightInPx / 2 to SwipingStates.EXPANDED
                    )
                )
                .nestedScroll(nestedScrollConnection)
        ) {
            val computedProgress by remember {
                derivedStateOf {
                    if (swipingState.progress.to == SwipingStates.COLLAPSED) {
                        swipingState.progress.fraction
                    } else {
                        1f - swipingState.progress.fraction
                    }
                }
            }
            MotionLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                motionScene = MotionScene(motionScene),
                progress = computedProgress
            ) {
                Box(
                    modifier = Modifier
                        .layoutId("carousel")
                        .background(MaterialTheme.colorScheme.background)
                        .height(210.dp)
                ) {
                    carouselContent()
                }

                Column(
                    modifier = Modifier
                        .layoutId("container_body")
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .height(48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            DragIndicator(Modifier.padding(top = 12.dp))
                        }
                    }
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            bodyContent()
                        }
                    }
                }
                Box(modifier = Modifier.layoutId("button_favorite")) {
                    FavoriteButton(isFavorite) {
                        if (computedProgress != 1f) {
                            onFavoriteClicked()
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .layoutId("button_open_map")
                        .padding(bottom = 20.dp)
                ) {
                    actionButton()
                }
            }
        }
    }
}

enum class SwipingStates {
    EXPANDED,
    COLLAPSED
}
