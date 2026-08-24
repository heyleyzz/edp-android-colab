package com.example.midtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Color(0xFF0288D1),
                    primaryContainer = Color(0xFFB3E5FC)
                )
            ) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    RecipeApp()
                }
            }
        }
    }
}