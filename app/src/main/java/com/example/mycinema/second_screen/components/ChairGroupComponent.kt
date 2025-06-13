package com.example.mycinema.second_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycinema.R
import com.example.mycinema.second_screen.state.Chair
import com.example.mycinema.second_screen.state.ChairGroup
import com.example.mycinema.ui.theme.BaseWhite
import com.example.mycinema.ui.theme.Neutral800
import com.example.mycinema.ui.theme.PrimaryAccent

@Composable
fun ChairGroupComponent(
    chairGroup: ChairGroup,
    onChairClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val firstChair = chairGroup.firstChair
    val secondChair = chairGroup.secondChair

    val groupBackgroundTint = when {
        firstChair.status == Chair.Status.Reserved &&
                secondChair.status == Chair.Status.Reserved -> PrimaryAccent.copy(0.5f)

        firstChair.status == Chair.Status.Occupied &&
                secondChair.status == Chair.Status.Occupied -> Neutral800.copy(0.7f)

        setOf(firstChair.status, secondChair.status)
            .containsAll(
                setOf(
                    Chair.Status.Reserved,
                    Chair.Status.Occupied
                )
            ) -> PrimaryAccent.copy(0.5f)

        else -> BaseWhite.copy(0.6f)
    }

    Box(
        modifier = modifier
            .padding(top = 16.dp)
            .graphicsLayer {
                rotationZ = when (chairGroup.rowIndex) {
                    1 -> 15f
                    3 -> -15f
                    else -> 0f
                }
                translationY = when (chairGroup.rowIndex) {
                    2 -> 0.dp.value
                    else -> (-32).dp.value
                }
            }) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(R.drawable.seat_container),
                contentDescription = "Seat Grouper",
                tint = groupBackgroundTint,
                modifier = Modifier
                    .scale(1.5f)
                    .padding(top = 6.dp)
            )

            Row(horizontalArrangement = Arrangement.Center) {
                chairGroup.chairs.sortedBy { it.columnIndex }.forEach { chair ->
                    Icon(
                        painter = painterResource(R.drawable.seat),
                        contentDescription = "Cinema Chair",
                        tint = when (chair.status) {
                            Chair.Status.Occupied -> Neutral800
                            Chair.Status.Reserved -> PrimaryAccent
                            Chair.Status.Available -> BaseWhite
                        },
                        modifier = Modifier
                            .size(42.dp)
                            .clickable(
                                enabled = chair.status != Chair.Status.Occupied,
                                onClick = { onChairClick(chair.id) }
                            )
                    )
                }
            }
        }
    }
}