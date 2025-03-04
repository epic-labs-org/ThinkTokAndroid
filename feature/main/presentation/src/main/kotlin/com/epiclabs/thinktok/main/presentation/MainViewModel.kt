package com.epiclabs.thinktok.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.GetSomethingUseCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val getSomethingUseCase: GetSomethingUseCase,
    private val getLanguagePreferenceUseCase: GetLanguagePreferenceUseCase,
) : ViewModel() {
    init {

        viewModelScope.launch {
            getLanguagePreferenceUseCase().also {
                println("Language preference is $it")
            }
        }
    }

    fun getSomething() = getSomethingUseCase()
}