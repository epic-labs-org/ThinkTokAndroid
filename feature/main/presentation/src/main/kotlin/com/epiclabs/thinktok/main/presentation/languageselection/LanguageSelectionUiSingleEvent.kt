package com.epiclabs.thinktok.main.presentation.languageselection

sealed class LanguageSelectionUiSingleEvent {
    data object NavigateBackIfNeeded : LanguageSelectionUiSingleEvent()
}