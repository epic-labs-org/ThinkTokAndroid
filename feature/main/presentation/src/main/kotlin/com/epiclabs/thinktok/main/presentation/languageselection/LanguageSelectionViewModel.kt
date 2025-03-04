package com.epiclabs.thinktok.main.presentation.languageselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.SetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent.LearningLanguageSelected
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent.LoadUserPreference
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent.OriginLanguageSelected
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent.SubmitClicked
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiSingleEvent.NavigateBackIfNeeded
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LanguageSelectionViewModel(
    private val getLanguagePreferenceUseCase: GetLanguagePreferenceUseCase,
    private val setLanguagePreferenceUseCase: SetLanguagePreferenceUseCase,
) :
    ViewModel() {
    private lateinit var cachedUerPreference: UserPreference

    private val _uiState = MutableStateFlow(LanguageSelectionUiState())
    val uiState: StateFlow<LanguageSelectionUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<LanguageSelectionUiSingleEvent>()
    val uiEvent: SharedFlow<LanguageSelectionUiSingleEvent> = _uiEvent.asSharedFlow()

    fun onUiIntent(intent: LanguageSelectionUiIntent) {
        when (intent) {
            is OriginLanguageSelected -> {
                cachedUerPreference = cachedUerPreference.copy(originLanguage = intent.language)
            }

            is LearningLanguageSelected -> {
                cachedUerPreference = cachedUerPreference.copy(learningLanguage = intent.language)
            }

            SubmitClicked -> {
                viewModelScope.launch {
                    setLanguagePreferenceUseCase(
                        originLanguage = cachedUerPreference.originLanguage,
                        learningLanguage = cachedUerPreference.learningLanguage,
                    )
                }
                viewModelScope.launch {
                    _uiEvent.emit(NavigateBackIfNeeded)
                }
            }

            LoadUserPreference -> {
                viewModelScope.launch {
                    getLanguagePreferenceUseCase()
                        .map {
                            it ?: UserPreference("Persian", "English")
                        }
                        .collect { userLanguagePreference ->
                            cachedUerPreference = userLanguagePreference
                            _uiState.update {
                                it.copy(
                                    languageSelectionUiModel =
                                        it.languageSelectionUiModel.copy(
                                            originLanguage = userLanguagePreference.originLanguage,
                                            learningLanguage = userLanguagePreference.learningLanguage,
                                        ),
                                )
                            }
                        }
                }
            }
        }
    }

    init {
        onUiIntent(LoadUserPreference)
    }
}
