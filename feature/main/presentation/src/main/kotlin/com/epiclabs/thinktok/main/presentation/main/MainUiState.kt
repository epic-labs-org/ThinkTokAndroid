package com.epiclabs.thinktok.main.presentation.main

data class MainUiState(
    val isLanguageSet: Boolean = false,
    val learningLanguage: String = "",
    val originLanguage: String = "",
    val isLoading: Boolean = true,
)