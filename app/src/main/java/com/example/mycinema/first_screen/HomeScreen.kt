package com.example.mycinema.first_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycinema.R
import com.example.mycinema.first_screen.components.BlurBackground
import com.example.mycinema.first_screen.components.HomeFilterChips
import com.example.mycinema.first_screen.components.HomeOverview
import com.example.mycinema.first_screen.components.HomePager
import com.example.mycinema.first_screen.state.HomeUIState
import com.example.mycinema.first_screen.viewmodel.HomeViewModel
import com.example.mycinema.ui.theme.OpenSans
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 1, pageCount = { 3 })

    HomeScreenContent(
        state = state, pagerState = pagerState
    )
}

@Composable
private fun HomeScreenContent(
    state: HomeUIState,
    pagerState: PagerState,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        BlurBackground(image = state.movies[pagerState.currentPage].imageRes)
        Column(
            modifier = Modifier.padding(top = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HomeFilterChips()
            HomePager(state.movies, pagerState = pagerState)
            HomeOverview(state, pagerState)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter)
        ) {
            BottomNavBar()
        }
    }

}

@Composable
fun BottomNavBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(45.dp)
                .clip(shape = CircleShape)
                .background(Color(0xFFFF5524)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.movie),
                contentDescription = "Video",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.size(28.dp)
            )
        }

        Icon(
            painter = painterResource(R.drawable.search),
            contentDescription = "Search",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(R.drawable.ticket),
                contentDescription = "Ticket",
                tint = Color.Black,
                modifier = Modifier.size(28.dp)
            )
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF5524)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "5", color = Color.White, fontSize = 12.sp, fontFamily = OpenSans
                )
            }
        }


        Icon(
            painter = painterResource(R.drawable.profile),
            contentDescription = "Profile",
            tint = Color.Black,
            modifier = Modifier.size(28.dp)
        )
    }
}
