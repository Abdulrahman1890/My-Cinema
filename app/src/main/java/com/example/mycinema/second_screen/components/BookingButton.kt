package com.example.mycinema.second_screen.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycinema.R
import com.example.mycinema.ui.theme.OpenSans
import com.example.mycinema.ui.theme.PrimaryAccent
import com.example.mycinema.ui.theme.BaseWhite

@Composable
fun BuyButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    BookingButtonContent(
        modifier = modifier,
        text = text,
        isPressed = isPressed,
        interactionSource = interactionSource,
        onClick = onClick
    )
}

@Composable
private fun BookingButtonContent(
    modifier: Modifier,
    text: String,
    isPressed: Boolean,
    interactionSource: MutableInteractionSource,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) PrimaryAccent.copy(alpha = 0.8f) else PrimaryAccent,
        label = "background_color"
    )

    val scale = if (isPressed) 0.96f else 1f

    Box(
        modifier = modifier
            .scale(scale)
            .background(backgroundColor, shape = CircleShape)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { onClick() }
    ) {
        ButtonContent(text = text)
    }
}

@Composable
private fun ButtonContent(text: String) {
    Row(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonIcon()
        ButtonText(text = text)
    }
}

@Composable
private fun ButtonIcon() {
    Icon(
        modifier = Modifier.size(32.dp),
        painter = painterResource(R.drawable.credit_card),
        contentDescription = "Credit Card for Booking",
        tint = BaseWhite
    )
}

@Composable
private fun ButtonText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = OpenSans,
            fontWeight = FontWeight.Medium,
            color = BaseWhite,
            fontSize = 16.sp
        )
    )
}