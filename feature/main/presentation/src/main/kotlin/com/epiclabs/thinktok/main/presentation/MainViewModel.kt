package com.epiclabs.thinktok.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.SetLanguagePreferenceUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getLanguagePreferenceUseCase: GetLanguagePreferenceUseCase,
    private val setLanguagePreferenceUseCase: SetLanguagePreferenceUseCase,
) : ViewModel() {
    init {

        viewModelScope.launch {
            setLanguagePreferenceUseCase(
                learningLanguage = "English",
                originLanguage = "Persian",
            )
            getLanguagePreferenceUseCase().also {
                println("Language preference is $it")
            }
        }
    }
}