package com.example.mycinema.first_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycinema.R
import com.example.mycinema.first_screen.state.HomeUIState
import com.example.mycinema.ui.theme.OpenSans

@Composable
fun HomeOverview(
    state: HomeUIState,
    pagerState: PagerState,
) {
    Column(
        modifier = Modifier.padding(vertical = 19.dp, horizontal = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(R.drawable.time),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = state.movies[pagerState.settledPage].duration,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 4.dp),
            )
        }
        Text(
            text = state
                .movies[pagerState.settledPage]
                .title.replaceFirstChar { it.uppercase() },
            fontFamily = OpenSans,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            lineHeight = 32.sp
        )
        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            state.movies[pagerState.settledPage].genres.forEach { genre ->
                AppChip(
                    label = genre,
                    onClick = {},
                    labelPadding = PaddingValues(2.dp),
                    borderColor = Color.LightGray,
                    labelStyle = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 12.sp,
                        letterSpacing = 0.15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}