package com.example.mycinema.second_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycinema.ui.theme.Neutral800
import com.example.mycinema.ui.theme.PrimaryAccent
import com.example.mycinema.ui.theme.BaseWhite

@Composable
fun SeatLegendSection() {
    Row(
        modifier = Modifier
            .padding(horizontal = 26.dp)
            .padding(top = 26.dp, bottom = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SeatLegend(label = "Available", colorIndicator = BaseWhite)
        SeatLegend(label = "Occupied", colorIndicator = Neutral800)
        SeatLegend(label = "Selected", colorIndicator = PrimaryAccent)
    }
}