package com.epiclabs.thinktok.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.presentation.languageselection.model.MainUiEvent
import com.epiclabs.thinktok.main.presentation.languageselection.model.MainUiEvent.LoadLanguagePreference
import com.epiclabs.thinktok.main.presentation.languageselection.model.MainUiState
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

    private fun onUiEvent(event: MainUiEvent) {
        when (event) {
            LoadLanguagePreference -> {
                viewModelScope.launch {
                    _uiState.update { it.copy(isLoading = true) }
                    getLanguagePreferenceUseCase().collect { languagePreference ->
                        populateLanguageSetting(languagePreference)
                    }
                }
            }
        }
    }

    private fun populateLanguageSetting(languagePreference: UserPreference?) {
        _uiState.update {
            if (languagePreference == null) {
                it.copy(
                    isLanguageSet = false,
                    isLoading = false,
                )
            } else {
                it.copy(
                    isLanguageSet = true,
                    learningLanguage = languagePreference.learningLanguage,
                    originLanguage = languagePreference.originLanguage,
                    isLoading = false,
                )
            }
        }
    }

    init {
        onUiEvent(LoadLanguagePreference)
    }
}