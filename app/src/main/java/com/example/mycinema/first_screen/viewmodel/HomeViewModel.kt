package com.example.mycinema.first_screen.viewmodel


import androidx.lifecycle.ViewModel
import com.example.mycinema.R
import com.example.mycinema.first_screen.state.HomeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeUIState())
    val state = _state.asStateFlow()

    private val dummyMovies = listOf(
        HomeUIState.MovieUIState(
            title = "Morbius",
            imageRes = R.drawable.movie1,
            duration = "1h 50m",
            genres = listOf("Horror", "Action", "Thriller")
        ), HomeUIState.MovieUIState(
            title = "Fantastic Beasts: The Secrets of Dumbledore",
            imageRes = R.drawable.movie2,
            duration = "2h 23m",
            genres = listOf("Adventure", "Fantasy", "Family")
        ), HomeUIState.MovieUIState(
            title = "Doctor Strange in the Multiverse of Madness",
            imageRes = R.drawable.movie3,
            duration = "3h 15m",
            genres = listOf("Action", "Adventure", "Fantasy")
        )
    )

    init {
        getDummyData()
    }

    private fun getDummyData() {
        _state.update { it.copy(movies = dummyMovies) }
    }
}
