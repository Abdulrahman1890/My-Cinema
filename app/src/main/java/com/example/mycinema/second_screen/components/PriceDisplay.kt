package com.example.mycinema.second_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mycinema.ui.theme.DeepBlack
import com.example.mycinema.ui.theme.Neutral600
import com.example.mycinema.ui.theme.OpenSans

@Composable
fun PriceDisplay(selectedSeatsCount: Int) {
    Column {
        Text(
            text = "$${selectedSeatsCount * 50}",
            style = TextStyle(
                color = DeepBlack,
                fontSize = 24.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Medium
            ),
        )
        Text(
            text = if (selectedSeatsCount > 0) "$selectedSeatsCount tickets" else "",
            style = TextStyle(
                color = Neutral600,
                fontSize = 12.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Normal
            ),
        )
    }
}