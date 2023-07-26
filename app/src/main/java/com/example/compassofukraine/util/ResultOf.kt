package com.example.compassofukraine.util

import java.lang.Exception

sealed class ResultOf<out T> {
    object Loading : ResultOf<Nothing>()
    data class Success<T>(val data: T) : ResultOf<T>()
    data class Error(val exception: Exception) : ResultOf<Nothing>()
}
