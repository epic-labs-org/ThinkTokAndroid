package com.epiclabs.thinktok.main.presentation.languageselection

import com.epiclabs.thinktok.main.presentation.languageselection.model.LanguageSelectionUiModel

data class LanguageSelectionUiState(
    val languageSelectionUiModel: LanguageSelectionUiModel =
        LanguageSelectionUiModel(
            yourLanguages = listOf("Persian"),
            originLanguage = "Persian",
            languagesToLearn = listOf("English"),
            learningLanguage = "English",
            yourLanguageLabel = "Your Language",
            languageToLearnLabel = "What language do you want to learn",
            buttonText = "Submit and continue",
            languagesToLearnEnabled = false,
        ),
)