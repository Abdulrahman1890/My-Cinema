package com.example.mycinema.first_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeFilterChips(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 28.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        AppChip(
            label = "Now Showing",
            onClick = {},
            enabled = true,
            modifier = Modifier.height(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        AppChip(
            label = "Coming Soon",
            onClick = {},
            enabled = false,
            modifier = Modifier.height(40.dp)
        )
    }
}