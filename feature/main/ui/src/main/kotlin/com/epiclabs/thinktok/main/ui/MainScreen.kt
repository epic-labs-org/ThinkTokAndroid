package com.epiclabs.thinktok.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.epiclabs.thinktok.main.presentation.MainViewModel
import com.epiclabs.thinktok.main.ui.languageselection.LanguageSelectionScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = modifier) {
        if (uiState.isLoading) {
            Text("Loading...")
        } else if (!uiState.isLanguageSet) {
            LanguageSelectionScreen()
        } else {
            Text("Learning Language: ${uiState.learningLanguage}")
            Text("Origin Language: ${uiState.originLanguage}")
        }
    }
}