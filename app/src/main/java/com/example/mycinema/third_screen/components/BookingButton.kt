package com.example.mycinema.third_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycinema.R
import com.example.mycinema.ui.theme.PrimaryAccent

@Composable
fun BookingButton(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                PrimaryAccent,
                shape = CircleShape,
            ).clip(RoundedCornerShape(50.dp)).clickable {}
            .padding(horizontal = 28.dp, vertical = 15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.credit_card),
                contentDescription = "play",
                tint = Color.White,

                )
            Spacer(modifier = Modifier.padding(horizontal = 7.dp))
            Text(
                text = "Booking",
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )
        }

    }
}