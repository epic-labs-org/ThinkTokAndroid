package com.epiclabs.thinktok.main.presentation.main

data class MainUiState(
    val hideLanguageSelectionScreen: Boolean = false,
    val learningLanguage: String = "",
    val originLanguage: String = "",
    val isLoading: Boolean = true,
)