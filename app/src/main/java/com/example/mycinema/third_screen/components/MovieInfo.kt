package com.example.mycinema.third_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieInfo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(40.dp)
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            MovieStatistics()

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(horizontal = 55.dp)
            ) {
                Text(
                    text = "Fantastic Beasts: The Secrets of Dumbledore",
                    color = Color.Black,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp,
                )
            }
            Row(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                MovieType(text = "Fantasy")
                Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                MovieType(text = "Adventure")
            }

            Spacer(modifier = Modifier.height(20.dp))

            MovieActors()

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(horizontal = 35.dp)
            ) {
                Text(
                    text = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him...",
                    color = Color.Black,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            BookingButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieInfoPreview() {
    MovieInfo()
}