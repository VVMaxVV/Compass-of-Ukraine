package com.example.compassofukraine.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compassofukraine.ui.EventFilterFragment
import com.example.compassofukraine.ui.item.EventItem
import com.example.compassofukraine.viewModel.EventsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
internal fun EventsScreen() {
    val eventsViewModel = koinViewModel<EventsViewModel>()
    val eventsList by remember { eventsViewModel.eventsListState }
    val isLoaded by rememberSaveable { eventsViewModel.isLoaded }
    val savedScrollPosition = rememberSaveable { mutableStateOf(0) }
    val scrollState = rememberLazyListState()
    val refreshState = rememberPullRefreshState(isLoaded, {
        eventsViewModel.fetchEvents()
    })
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val bottomSheetScope = rememberCoroutineScope()

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
            items(eventsList) {
                EventItem(event = it) { id ->
//                    TODO("Open PDP by id")
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

    Box{
        ModalBottomSheetLayout(
            modifier = Modifier.fillMaxWidth(),
            sheetState = bottomSheetState,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            sheetContent = { EventFilterFragment(state = bottomSheetState, scope = bottomSheetScope)}
        ) {
            Button(
                onClick = {
                    bottomSheetScope.launch {
                        if (bottomSheetState.isVisible) bottomSheetState.hide()
                        else bottomSheetState.show()
                    }
                }
            ) {
                Text(text = "Filter")
            }
        }

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
