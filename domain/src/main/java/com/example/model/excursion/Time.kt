package com.example.model.excursion

class Time(private val Hours: Int, private val Minutes: Int) {
    override fun toString(): String {
        val sb = StringBuilder()
        if (Hours != 0) sb.append("$Hours h ")
        if (Minutes != 0) sb.append("$Minutes m ")
        return sb.toString()
    }
}
