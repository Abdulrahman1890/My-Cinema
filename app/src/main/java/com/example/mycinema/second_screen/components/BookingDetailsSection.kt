package com.example.mycinema.second_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycinema.second_screen.state.ShowDate
import com.example.mycinema.second_screen.state.ShowTime
import com.example.mycinema.ui.theme.BaseWhite

@Composable
fun BookingDetailsSection(
    showDates: List<ShowDate>,
    showTimes: List<ShowTime>,
    selectedSeatsCount: Int,
    onDateSelection: (Int) -> Unit,
    onTimeSelection: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxSize()
            .background(
                BaseWhite,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            .padding(top = 24.dp)
    ) {
        BookingDatesSection(showDates, onDateSelection)

        Spacer(modifier = Modifier.height(8.dp))

        MovieTimesSection(showTimes, onTimeSelection)

        Spacer(modifier = Modifier.height(16.dp))

        PurchaseSection(selectedSeatsCount = selectedSeatsCount)
    }
}
