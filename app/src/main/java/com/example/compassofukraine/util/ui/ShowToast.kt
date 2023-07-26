package com.example.compassofukraine.util.ui

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ShowToast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(LocalContext.current, message, length).show()
}
