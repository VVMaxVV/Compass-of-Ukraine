package com.example.compassofukraine.ui.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomePage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "HOME PAGE",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
