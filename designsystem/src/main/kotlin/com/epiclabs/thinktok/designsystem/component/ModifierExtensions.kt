package com.epiclabs.thinktok.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.cardStyle(): Modifier =
    this
        .clip(MaterialTheme.shapes.large)
        .border(1.dp, MaterialTheme.colorScheme.surfaceContainerLow, MaterialTheme.shapes.large)
        .background(MaterialTheme.colorScheme.surfaceContainerLowest)