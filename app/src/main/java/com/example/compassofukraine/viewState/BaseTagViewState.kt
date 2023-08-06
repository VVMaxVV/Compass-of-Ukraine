package com.example.compassofukraine.viewState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.model.Tag

abstract class BaseTagViewState(
    open val tag: Tag,
    open val listPosition: Int
) {
    open var isSelected = mutableStateOf(false)

    @Composable
    abstract fun display(onClick: (viewState: BaseTagViewState) -> Unit)
}