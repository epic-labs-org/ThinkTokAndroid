package com.epiclabs.thinktok.main.presentation.languageselection

sealed class LanguageSelectionUiIntent {
    data class OriginLanguageSelected(val language: String) : LanguageSelectionUiIntent()

    data class LearningLanguageSelected(val language: String) : LanguageSelectionUiIntent()

    data object SubmitClicked : LanguageSelectionUiIntent()

    data object LoadUserPreference : LanguageSelectionUiIntent()

    data object PopulateStringResources : LanguageSelectionUiIntent()
}