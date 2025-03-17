package com.epiclabs.thinktok.main.ui.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun LanguageSwitcherIcon(
    modifier: Modifier = Modifier,
    onLanguageSetClicked: () -> Unit = {},
) {
    IconButton(modifier = modifier, onClick = onLanguageSetClicked) {
        Icon(
            imageVector = Icons.Filled.Language,
            contentDescription = "Change Language",
        )
    }
}