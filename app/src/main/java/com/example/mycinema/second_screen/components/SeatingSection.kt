package com.example.mycinema.second_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycinema.second_screen.state.ChairGroup

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SeatingSection(
    chairGroups: List<ChairGroup>,
    onChairSelection: (Int) -> Unit
) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        maxItemsInEachRow = 3
    ) {
        chairGroups.forEach { chairGroup ->
            ChairGroupComponent(
                chairGroup = chairGroup,
                onChairClick = onChairSelection
            )
        }
    }
}