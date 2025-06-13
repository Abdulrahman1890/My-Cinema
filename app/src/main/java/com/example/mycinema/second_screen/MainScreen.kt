package com.example.mycinema.second_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mycinema.second_screen.components.BookingDetailsSection
import com.example.mycinema.second_screen.components.SeatLegendSection
import com.example.mycinema.second_screen.components.SeatingSection
import com.example.mycinema.second_screen.components.TheaterSection
import com.example.mycinema.second_screen.components.TopBar
import com.example.mycinema.second_screen.state.ChairGroup
import com.example.mycinema.second_screen.state.ShowDate
import com.example.mycinema.second_screen.state.ShowTime
import com.example.mycinema.second_screen.viewmodel.MovieReservationViewModel
import com.example.mycinema.ui.theme.DeepBlack
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieReservationScreen(controller: MovieReservationViewModel = koinViewModel()) {
    LaunchedEffect(key1 = Unit) {
        controller.initializeBookingData()
    }

    val chairGroups by controller.chairGroups.collectAsStateWithLifecycle()
    val showTimes by controller.showTimes.collectAsStateWithLifecycle()
    val showDates by controller.showDates.collectAsStateWithLifecycle()
    val selectedSeatsCount by controller.selectedSeatsCount.collectAsStateWithLifecycle()

    MovieReservationScreenContent(
        chairGroups = chairGroups,
        showTimes = showTimes,
        showDates = showDates,
        selectedSeatsCount = selectedSeatsCount,
        onChairSelection = controller::handleChairSelection,
        onTimeSelection = controller::handleTimeSelection,
        onDateSelection = controller::handleDateSelection
    )
}

@Composable
private fun MovieReservationScreenContent(
    chairGroups: List<ChairGroup>,
    showTimes: List<ShowTime>,
    showDates: List<ShowDate>,
    selectedSeatsCount: Int,
    onChairSelection: (Int) -> Unit,
    onTimeSelection: (Int) -> Unit,
    onDateSelection: (Int) -> Unit
) {
    Box(
        modifier = Modifier.background(DeepBlack)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .wrapContentHeight(unbounded = false)
        ) {
            TopBar()

            TheaterSection()

            SeatingSection(
                chairGroups = chairGroups,
                onChairSelection = onChairSelection
            )

            SeatLegendSection()

            BookingDetailsSection(
                showDates = showDates,
                showTimes = showTimes,
                selectedSeatsCount = selectedSeatsCount,
                onDateSelection = onDateSelection,
                onTimeSelection = onTimeSelection
            )
        }
    }
}