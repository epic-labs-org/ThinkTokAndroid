package com.epiclabs.thinktok.main.presentation.languageselection.model

import androidx.compose.runtime.Immutable

@Immutable
data class LanguageSelectionUiModel(
    val yourLanguages: List<String>,
    val selectedYourLanguage: String,
    val languagesToLearn: List<String>,
    val selectedLanguageTo: String,
    val yourLanguageLabel: String,
    val languageToLearnLabel: String,
    val buttonText: String,
)