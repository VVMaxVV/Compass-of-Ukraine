package com.example.compassofukraine.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DragIndicator() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onSurfaceVariant, RoundedCornerShape(3.dp))
            .size(width = 60.dp, height = 6.dp)
    )
}
