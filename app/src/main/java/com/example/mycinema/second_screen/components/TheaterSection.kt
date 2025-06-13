package com.example.mycinema.second_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.example.mycinema.R

@Composable
fun TheaterSection() {
    TheaterDisplay(
        modifier = Modifier.alpha(0.8f),
        posterResource = R.drawable.film_poster
    )
}