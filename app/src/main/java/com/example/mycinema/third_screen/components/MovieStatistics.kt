package com.example.mycinema.third_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieStatistics() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Row {
                Text(
                    text = "6.8",
                    color = Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "/10",
                    color = Color.Gray,
                    fontSize = 20.sp
                )
            }

            Text(
                text = "IMDb",
                color = Color.Gray,
                fontSize = 15.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "63%",
                color = Color.Black,
                fontSize = 20.sp
            )
            Text(
                text = "Rotten Tomatoes",
                color = Color.Gray,
                fontSize = 15.sp
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Row {
                Text(
                    text = "4",
                    color = Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "/10",
                    color = Color.Gray,
                    fontSize = 20.sp
                )
            }

            Text(
                text = "IGN",
                color = Color.Gray,
                fontSize = 15.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MovieStatisticsPreview() {
    MovieStatistics()
}