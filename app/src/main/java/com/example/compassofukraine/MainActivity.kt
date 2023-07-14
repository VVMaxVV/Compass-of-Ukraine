package com.example.compassofukraine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    Modifier.padding(it)
                    BottomNavGraph(navHostController = navHostController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CompassOfUkraineTheme {
        Greeting("Android")
    }
}
