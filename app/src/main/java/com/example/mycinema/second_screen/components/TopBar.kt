package com.example.mycinema.second_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycinema.R
import com.example.mycinema.ui.theme.Neutral600
import com.example.mycinema.ui.theme.BaseWhite

@Composable
fun TopBar() {
    Icon(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
            .clip(CircleShape)
            .background(Neutral600.copy(alpha = 0.4f))
            .padding(4.dp)
            .size(22.dp),
        painter = painterResource(R.drawable.close),
        contentDescription = "Close",
        tint = BaseWhite,
    )
}
