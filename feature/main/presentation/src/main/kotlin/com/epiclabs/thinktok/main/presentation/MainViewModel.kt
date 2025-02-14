package com.epiclabs.thinktok.main.presentation

import androidx.lifecycle.ViewModel
import com.epiclabs.thinktok.main.domain.GetSomethingUseCase

class MainViewModel (
    private val getSomethingUseCase: GetSomethingUseCase,
) : ViewModel() {

    fun getSomething() =getSomethingUseCase()
}