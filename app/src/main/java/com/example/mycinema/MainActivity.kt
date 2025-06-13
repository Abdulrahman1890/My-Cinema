package com.example.mycinema

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mycinema.first_screen.HomeScreen
import com.example.mycinema.second_screen.MovieReservationScreen
import com.example.mycinema.third_screen.MovieDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
             MovieDetailsScreen()
            // MovieReservationScreen()
            // HomeScreen()
        }
    }
}