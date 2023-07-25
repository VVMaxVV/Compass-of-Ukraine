package com.example.compassofukraine.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun Carousel(listUrl: List<String>?, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        if (listUrl.isNullOrEmpty()) {
            Box(modifier = Modifier.fillMaxSize().background(Brush.shimmerBrush()))
        } else {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(listUrl) { imageUrl ->
                    val showShimmer = remember { mutableStateOf(true) }
                    ShimmingAsyncImage(
                        model = imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .background(Brush.shimmerBrush(showShimmer.value)),
                        contentScale = ContentScale.Crop,
                        onSuccess = { showShimmer.value = false }
                    )
                }
            }
        }
    }
}
