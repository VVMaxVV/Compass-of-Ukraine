package com.example.compassofukraine.viewModel.excursion

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compassofukraine.util.ResultOf
import com.example.model.excursion.DetailedExcursion
import com.example.useCase.excursion.AddExcursionToFavouriteUseCase
import com.example.useCase.excursion.GetDetailsExcursionUseCase
import com.example.useCase.excursion.IsExcursionInFavoriteUseCase
import com.example.useCase.excursion.RemoveExcursionFromFavouriteUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class ExcursionDetailViewModel(
    private val getDetailsExcursionUseCase: GetDetailsExcursionUseCase,
    private val addExcursionToFavoriteUseCase: AddExcursionToFavouriteUseCase,
    private val removeExcursionFromFavoriteUseCase: RemoveExcursionFromFavouriteUseCase,
    private val isExcursionInFavoriteUseCase: IsExcursionInFavoriteUseCase
) : ViewModel() {

    private val _excursion: MutableState<ResultOf<DetailedExcursion>> = mutableStateOf(ResultOf.Loading)
    val excursion: State<ResultOf<DetailedExcursion>> get() = _excursion

    private val _isExcursionInFavorite = mutableStateOf(false)
    val isExcursionInFavorite: State<Boolean> = _isExcursionInFavorite

    fun fetchExcursionDetails(id: Int) {
        viewModelScope.launch {
            try {
                _excursion.value = ResultOf.Success(getDetailsExcursionUseCase.execute(id))
            } catch (e: SocketTimeoutException) {
                _excursion.value = ResultOf.Error(e)
            }
        }
    }

    private var addToFavoriteJob: Job? = null
    private var removeFromFavoriteJob: Job? = null

    fun updateFavorite(id: Int) {
        if (isExcursionInFavorite.value) {
            removeFromFavorite(id)
        } else {
            addToFavorite(id)
        }
    }

    private fun addToFavorite(id: Int) {
        removeFromFavoriteJob?.cancel()
        addToFavoriteJob = viewModelScope.launch {
            try {
                _isExcursionInFavorite.value = true
                addExcursionToFavoriteUseCase.execute(id)
            } catch (e: SocketTimeoutException) {
                _isExcursionInFavorite.value = false
            }
        }
    }

    private fun removeFromFavorite(id: Int) {
        addToFavoriteJob?.cancel()
        viewModelScope.launch {
            try {
                _isExcursionInFavorite.value = false
                removeExcursionFromFavoriteUseCase.execute(id)
            } catch (e: SocketTimeoutException) {
                _isExcursionInFavorite.value = true
            }
        }
    }

    fun fetchIsFavorite(id: Int) {
        viewModelScope.launch {
            isExcursionInFavoriteUseCase.execute(id)
        }
    }
}
