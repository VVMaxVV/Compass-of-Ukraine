package com.example.compassofukraine.viewModel.excursion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.model.Excursion
import com.example.useCase.GetExcursionUseCase

class ExcursionDetailViewModel(
    private val getExcursionUseCase: GetExcursionUseCase
) : ViewModel() {

    private val _excursionState = mutableStateOf<Excursion?>(null)
    val excursionState: State<Excursion?> get() = _excursionState

    private val _isLoaded = mutableStateOf(false)
    val isLoaded: State<Boolean> get() = _isLoaded

}