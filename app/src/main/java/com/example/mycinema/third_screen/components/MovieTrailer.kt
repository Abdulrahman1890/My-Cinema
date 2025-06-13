package com.example.mycinema.third_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycinema.R
import com.example.mycinema.ui.theme.PrimaryAccent

@Composable
fun MovieTrailer() {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.secret_movie),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            Color(0xff99684a).copy(alpha = 0.8f),
                            shape = CircleShape,
                        )
                        .clip(RoundedCornerShape(100.dp))
                        .clickable {}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.close),
                        contentDescription = "close",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(7.dp)
                            .size(30.dp)
                    )
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(
                            Color(0xff595959).copy(alpha = 0.6f),
                            shape = CircleShape,
                        )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.time),
                            contentDescription = "time",
                            tint = Color.LightGray,
                            modifier = Modifier.blur(0.5.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "2h 23m",
                            color = Color.White,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(
                        PrimaryAccent,
                        shape = CircleShape,
                    )
                    .clickable {}

            ) {
                Icon(
                    painter = painterResource(R.drawable.play),
                    contentDescription = "play",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(18.dp)
                        .size(30.dp)
                        .offset(x = 2.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieTrailerPreview() {
    MovieTrailer()
}