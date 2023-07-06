package com.example.compassofukraine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.compassofukraine.ui.BottomBar
import com.example.compassofukraine.ui.theme.CompassOfUkraineTheme
import com.example.compassofukraine.util.BottomNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompassOfUkraineTheme {
                val navHostController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomBar(navHostController = navHostController)
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        BottomNavGraph(navHostController = navHostController)
                    }
                }
            }
        }
    }
}
