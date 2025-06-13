package com.example.mycinema.second_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycinema.second_screen.state.ShowTime
import com.example.mycinema.ui.theme.DeepBlack
import com.example.mycinema.ui.theme.Neutral600
import com.example.mycinema.ui.theme.Neutral100
import com.example.mycinema.ui.theme.OpenSans
import com.example.mycinema.ui.theme.BaseWhite

@Composable
fun MovieTimesSection(
    showTimes: List<ShowTime>,
    onTimeSelection: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier.padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(showTimes) { timeSlot ->
            Column(
                modifier = Modifier.border(
                    1.dp,
                    if (timeSlot.isActive) Neutral600 else Neutral100,
                    RoundedCornerShape(24.dp)
                )
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { onTimeSelection(timeSlot.id) }
                    .background(if (timeSlot.isActive) Neutral600 else Color.Transparent)
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = timeSlot.timeSlot,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (timeSlot.isActive) BaseWhite else DeepBlack,
                    fontFamily = OpenSans,
                )
            }
        }
    }
}