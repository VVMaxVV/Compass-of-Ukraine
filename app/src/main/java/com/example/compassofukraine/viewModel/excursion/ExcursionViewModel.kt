package com.example.compassofukraine.viewModel.excursion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.model.Excursion
import com.example.model.Location
import com.example.useCase.excursion.GetExcursionUseCase
import kotlinx.coroutines.launch

class ExcursionViewModel(
    private val getExcursionUseCase: GetExcursionUseCase
) : ViewModel() {

    private val _excursionsListState = mutableStateOf<List<Excursion>>(emptyList())
    val excursionsListState: State<List<Excursion>> get() = _excursionsListState

    private val _isLoaded = mutableStateOf(false)
    val isLoaded: State<Boolean> get() = _isLoaded

    init {
        fetchExcursions()
    }

    fun fetchExcursions() {
        viewModelScope.launch {
            _isLoaded.value = true
            _excursionsListState.value = getExcursionUseCase.execute(Location.Kharkiv)
            _isLoaded.value = false
        }
    }
}
