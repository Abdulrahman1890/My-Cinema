package com.example.mycinema.third_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycinema.third_screen.components.MovieInfo
import com.example.mycinema.third_screen.components.MovieTrailer

@Composable
fun MovieDetailsScreen() {
    MovieTrailer()
    Box(modifier = Modifier.offset(y = (450.dp))) {
        MovieInfo()
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}