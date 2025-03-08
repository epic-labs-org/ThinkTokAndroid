package com.epiclabs.thinktok.main.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.presentation.main.MainUiIntent.LoadLanguagePreference
import com.epiclabs.thinktok.main.presentation.main.MainUiIntent.OnSetLanguageClicked
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getLanguagePreferenceUseCase: GetLanguagePreferenceUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun onUiIntent(intent: MainUiIntent) {
        when (intent) {
            LoadLanguagePreference -> {
                viewModelScope.launch {
                    _uiState.update { it.copy(isLoading = true) }
                    getLanguagePreferenceUseCase().collect { languagePreference ->
                        populateLanguageSetting(languagePreference)
                    }
                }
            }

            OnSetLanguageClicked -> {
                setLanguageSelectionScreenVisibility()
            }
        }
    }

    private fun setLanguageSelectionScreenVisibility() {
        _uiState.update {
            it.copy(
                hideLanguageSelectionScreen = false,
            )
        }
    }

    private fun populateLanguageSetting(languagePreference: UserPreference?) {
        _uiState.update {
            if (languagePreference == null) {
                it.copy(
                    hideLanguageSelectionScreen = false,
                    isLoading = false,
                )
            } else {
                it.copy(
                    hideLanguageSelectionScreen = true,
                    learningLanguage = languagePreference.learningLanguage,
                    originLanguage = languagePreference.originLanguage,
                    isLoading = false,
                )
            }
        }
    }

    init {
        onUiIntent(LoadLanguagePreference)
    }
}