package com.epiclabs.thinktok.main.presentation.di

import com.epiclabs.thinktok.main.presentation.main.MainViewModel
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionViewModel
import com.epiclabs.thinktok.main.presentation.main.mapper.WordMapper
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val mainModule =
    module {
        factory {
            WordMapper()
        }
        viewModel {
            MainViewModel(get())
        }
        viewModel {
            LanguageSelectionViewModel(get(), get(), get())
        }
    }