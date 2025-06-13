package com.example.mycinema.second_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycinema.ui.theme.AccentOverlay

@Composable
fun TheaterDisplay(
    posterResource: Int,
    modifier: Modifier = Modifier
) {
    val screenTopRatio = 0.15f
    val curveOffset = -30f

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .drawBehind {
                val screenPath = Path().apply {
                    moveTo(0f, size.height * screenTopRatio)
                    quadraticTo(
                        size.width / 2f,
                        curveOffset,
                        size.width,
                        size.height * screenTopRatio
                    )
                }

                drawPath(
                    path = screenPath,
                    color = AccentOverlay,
                    style = Stroke(width = 2.dp.toPx())
                )
            }
            .clip(
                GenericShape { size, _ ->
                    moveTo(0f, size.height * screenTopRatio)
                    quadraticTo(
                        size.width / 2f,
                        curveOffset,
                        size.width,
                        size.height * screenTopRatio
                    )
                    lineTo(size.width, size.height * 0.75f)
                    arcTo(
                        rect = Rect(
                            left = 0f,
                            top = size.height * 0.62f,
                            right = size.width,
                            bottom = size.height * 1f
                        ),
                        startAngleDegrees = 0f,
                        sweepAngleDegrees = -180f,
                        forceMoveTo = false
                    )
                    close()
                }
            )
            .graphicsLayer {
                scaleY = 0.9f
                scaleX = 0.75f
                rotationX = -45f
            }
    ) {
        Image(
            painter = painterResource(id = posterResource),
            contentDescription = "Movie Poster",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .matchParentSize()
                .offset(y = (-50).dp)
        )
    }
}