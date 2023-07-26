package com.example.model

sealed class EventTime {
    object AllDay : EventTime()
    data class Time(val start: String, val finish: String) : EventTime()
}
