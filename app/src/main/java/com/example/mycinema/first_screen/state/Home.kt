package com.example.mycinema.first_screen.state

data class HomeUIState(
    val movies: List<MovieUIState> = emptyList(),
) {
    data class MovieUIState(
        val title: String = "",
        val imageRes: Int = 0,
        val duration: String = "",
        val genres: List<String> = emptyList(),
    )
}
