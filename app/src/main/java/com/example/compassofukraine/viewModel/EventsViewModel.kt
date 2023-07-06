package com.example.compassofukraine.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Event
import com.example.model.Location
import com.example.useCase.GetEventsUseCase
import kotlinx.coroutines.launch

class EventsViewModel(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    private val _eventsListState = mutableStateOf<List<Event>>(emptyList())
    val eventsListState: State<List<Event>> get() = _eventsListState

    private val _isLoaded = mutableStateOf(false)
    val isLoaded: State<Boolean> get() = _isLoaded

    init {
        fetchEvents()
    }

    fun fetchEvents() {
        viewModelScope.launch {
            _isLoaded.value = true
            _eventsListState.value = getEventsUseCase.execute(Location.Kharkiv)
            _isLoaded.value = false
        }
    }
}
