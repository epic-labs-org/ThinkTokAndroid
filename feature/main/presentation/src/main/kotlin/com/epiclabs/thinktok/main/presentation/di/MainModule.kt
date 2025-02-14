package com.epiclabs.thinktok.main.presentation.di

import com.epiclabs.thinktok.main.presentation.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {

    viewModel {
        MainViewModel(get())
    }
}