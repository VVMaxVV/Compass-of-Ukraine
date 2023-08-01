package com.example.compassofukraine.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compassofukraine.ui.item.ExcursionItem
import com.example.compassofukraine.viewModel.ExcursionViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
internal fun ExcursionScreen() {
    val excursionViewModel = koinViewModel<ExcursionViewModel>()
    val excursionList by remember { excursionViewModel.excursionsListState }
    val isLoaded by rememberSaveable { excursionViewModel.isLoaded }
    val savedScrollPosition = rememberSaveable { mutableStateOf(0) }
    val scrollState = rememberLazyListState()
    val refreshState = rememberPullRefreshState(isLoaded, {
        excursionViewModel.fetchExcursions()
    })

    Box {
        LazyColumn(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .pullRefresh(refreshState, true),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = scrollState
        ) {
            items(excursionList) {
                ExcursionItem(excursion = it) { id ->
                    //   TODO("Open EDP by id")
                }
            }
        }
        PullRefreshIndicator(
            refreshing = isLoaded,
            state = refreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    }

    LaunchedEffect(isLoaded) {
        if (!isLoaded) {
            scrollState.animateScrollToItem(0)
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            savedScrollPosition.value = scrollState.firstVisibleItemIndex
        }
    }

    LaunchedEffect(Unit) {
        scrollState.scrollToItem(savedScrollPosition.value)
    }
}
