package com.example.mycinema.third_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MovieType(text: String){
        Box(
            modifier = Modifier
                .border(width = 1.dp, color = Color.Gray.copy(alpha = 0.3f), shape = CircleShape)
                .padding(horizontal = 15.dp, vertical = 5.dp)
        ) {
            Text(
                text = text,
                color = Color.Black,
            )
        }
}