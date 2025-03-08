package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.epiclabs.thinktok.main.presentation.main.MainUiIntent.OnSetLanguageClicked
import com.epiclabs.thinktok.main.presentation.main.MainUiState
import com.epiclabs.thinktok.main.presentation.main.MainViewModel
import com.epiclabs.thinktok.main.ui.languageselection.LanguageSelectionScreen
import org.koin.androidx.compose.koinViewModel
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Add

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    MainScreen(modifier, uiState) { viewModel.onUiIntent(OnSetLanguageClicked) }
}

@Composable
private fun MainScreen(
    modifier: Modifier = Modifier,
    uiState: MainUiState,
    onLanguageSetClicked: () -> Unit = {},
) {
    Column(modifier = modifier) {
        when {
            uiState.isLoading -> {
                Text("Loading...")
            }

            !uiState.hideLanguageSelectionScreen -> {
                LanguageSelectionScreen()
            }

            else -> {
                IconButton(onClick = onLanguageSetClicked) {
                    Icon(
                        imageVector = Filled.Add,
                        contentDescription = "Change Language",
                        modifier = Modifier.clickable { onLanguageSetClicked() },
                    )
                }
                Text("Learning Language: ${uiState.learningLanguage}")
                Text("Origin Language: ${uiState.originLanguage}")
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(
        uiState =
            MainUiState(
                hideLanguageSelectionScreen = false,
                learningLanguage = "Persian",
                originLanguage = "English",
                isLoading = false,
            ),
    )
}