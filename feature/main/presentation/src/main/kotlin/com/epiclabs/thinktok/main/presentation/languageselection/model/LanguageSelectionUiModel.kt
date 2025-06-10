package com.epiclabs.thinktok.main.presentation.languageselection.model

import androidx.compose.runtime.Immutable

@Immutable
data class LanguageSelectionUiModel(
    val yourLanguages: List<String>,
    val chooseLanguageHint: String,
    val originLanguage: String,
    val languagesToLearn: List<String>,
    val languagesToLearnEnabled: Boolean,
    val learningLanguage: String,
    val yourLanguageLabel: String,
    val languageToLearnLabel: String,
    val buttonText: String,
)