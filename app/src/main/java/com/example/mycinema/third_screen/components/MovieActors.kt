package com.example.mycinema.third_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mycinema.R

@Composable
fun MovieActors() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth() ,
        contentPadding = PaddingValues(horizontal = 30.dp)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.actor1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Image(
                painter = painterResource(id = R.drawable.actor2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Image(
                painter = painterResource(id = R.drawable.actor3),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Image(
                painter = painterResource(id = R.drawable.actor6),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Image(
                painter = painterResource(id = R.drawable.actor7),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Image(
                painter = painterResource(id = R.drawable.actor1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))

        }
    }
}