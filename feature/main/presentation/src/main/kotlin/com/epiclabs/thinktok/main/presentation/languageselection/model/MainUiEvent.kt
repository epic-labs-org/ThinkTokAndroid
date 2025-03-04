package com.epiclabs.thinktok.main.presentation.languageselection.model

sealed class MainUiEvent {
    data object LoadLanguagePreference : MainUiEvent()
}