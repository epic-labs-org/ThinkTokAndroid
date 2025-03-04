package com.epiclabs.thinktok.main.presentation.languageselection

import com.epiclabs.thinktok.main.presentation.languageselection.model.LanguageSelectionUiModel

data class LanguageSelectionUiState(
    val languageSelectionUiModel: LanguageSelectionUiModel =
        LanguageSelectionUiModel(
            yourLanguages = listOf(),
            originLanguage = "",
            languagesToLearn = listOf(),
            learningLanguage = "",
            yourLanguageLabel = "e",
            languageToLearnLabel = "",
            buttonText = "",
            languagesToLearnEnabled = false,
        ),
)