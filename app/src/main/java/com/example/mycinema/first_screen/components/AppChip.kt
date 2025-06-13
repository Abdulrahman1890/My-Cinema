package com.example.mycinema.first_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppChip(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    labelPadding: PaddingValues = PaddingValues(4.dp),
    borderColor: Color = Color.Gray,
    labelStyle: TextStyle = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
        color = White
    )
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .background(if (enabled) Color(0xFFFF5524) else Color.Transparent)
            .border(
                if (!enabled) BorderStroke(1.dp, borderColor)
                else BorderStroke(0.dp, Color.Transparent),
                shape = RoundedCornerShape(50.dp)
            )
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(labelPadding).align(Alignment.Center),
            style = labelStyle,
        )
    }

}