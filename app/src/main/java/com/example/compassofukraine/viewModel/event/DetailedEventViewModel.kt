package com.example.compassofukraine.viewModel.event

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compassofukraine.util.ResultOf
import com.example.model.DetailedEvent
import com.example.useCase.AddEventToFavoriteUseCase
import com.example.useCase.GetDetailsEventsUseCase
import com.example.useCase.IsEventInFavoriteUseCase
import com.example.useCase.RemoveEventFromFavoriteUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class DetailedEventViewModel(
    private val getDetailsEventsUseCase: GetDetailsEventsUseCase,
    private val addEventToFavoriteUseCase: AddEventToFavoriteUseCase,
    private val removeEventFromFavoriteUseCase: RemoveEventFromFavoriteUseCase,
    private val isEventInFavoriteUseCase: IsEventInFavoriteUseCase
) : ViewModel() {
    private val _event: MutableState<ResultOf<DetailedEvent>> = mutableStateOf(ResultOf.Loading)
    val event: State<ResultOf<DetailedEvent>> get() = _event

    private val _isEventInFavorite = mutableStateOf(false)
    val isEventInFavorite: State<Boolean> = _isEventInFavorite

    fun fetchEventDetails(id: Int) {
        viewModelScope.launch {
            try {
                _event.value = ResultOf.Success(getDetailsEventsUseCase.execute(id))
            } catch (e: SocketTimeoutException) {
                _event.value = ResultOf.Error(e)
            }
        }
    }

    private var addToFavoriteJob: Job? = null
    private var removeFromFavoriteJob: Job? = null

    fun updateFavorite(id: Int) {
        if (isEventInFavorite.value) {
            removeFromFavorite(id)
        } else {
            addToFavorite(id)
        }
    }

    private fun addToFavorite(id: Int) {
        removeFromFavoriteJob?.cancel()
        addToFavoriteJob = viewModelScope.launch {
            try {
                _isEventInFavorite.value = true
                addEventToFavoriteUseCase.execute(id)
            } catch (e: SocketTimeoutException) {
                _isEventInFavorite.value = false
            }
        }
    }

    private fun removeFromFavorite(id: Int) {
        addToFavoriteJob?.cancel()
        viewModelScope.launch {
            try {
                _isEventInFavorite.value = false
                removeEventFromFavoriteUseCase.execute(id)
            } catch (e: SocketTimeoutException) {
                _isEventInFavorite.value = true
            }
        }
    }

    fun fetchIsFavorite(id: Int) {
        viewModelScope.launch {
            isEventInFavoriteUseCase.execute(id)
        }
    }
}
