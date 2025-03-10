package com.epiclabs.thinktok.main.presentation.main

sealed class MainUiIntent {
    data object LoadLanguagePreference : MainUiIntent()

    data object OnSetLanguageClicked : MainUiIntent()
}