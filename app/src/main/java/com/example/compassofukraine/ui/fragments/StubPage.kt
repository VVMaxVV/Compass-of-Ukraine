package com.example.compassofukraine.ui.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NavigationPage() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Coming soon...",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
