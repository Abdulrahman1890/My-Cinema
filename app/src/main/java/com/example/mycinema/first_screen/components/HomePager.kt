package com.example.mycinema.first_screen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.example.mycinema.first_screen.state.HomeUIState

@Composable
fun HomePager(
    images: List<HomeUIState.MovieUIState>,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
) {
    HorizontalPager(
        contentPadding = PaddingValues(horizontal = 60.dp),
        pageSpacing = (-15).dp,
        state = pagerState,
    ) { page ->
        val scale = animateFloatAsState(
            targetValue = if (page == pagerState.currentPage) 1.0f else 0.8f,
            label = ""
        ).value

        MovieItem(
            image = images[page].imageRes,
            modifier = modifier.padding(top = 5.dp)
                .scale(scale)
        )
    }
}