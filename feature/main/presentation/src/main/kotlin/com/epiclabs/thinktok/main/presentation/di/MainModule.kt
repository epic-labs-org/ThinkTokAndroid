package com.epiclabs.thinktok.main.presentation.di

import com.epiclabs.thinktok.main.presentation.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// TODO("It's a test module! it will be removed as part of #30")
val mainModule =
    module {

        viewModel {
            MainViewModel(get())
        }
    }