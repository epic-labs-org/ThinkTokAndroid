package com.epiclabs.thinktok.main.domain.di

import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.SetLanguagePreferenceUseCase
import kotlinx.coroutines.Dispatchers.IO
import org.koin.dsl.module
import com.epiclabs.thinktok.core.ioDispatcherQualifier
import com.epiclabs.thinktok.main.domain.GetLanguageScreenStringResourcesUseCase
import kotlinx.coroutines.CoroutineDispatcher

val mainDomainModule =
    module {
        single<CoroutineDispatcher>(qualifier = ioDispatcherQualifier) {
            IO
        }
        factory {
            GetLanguagePreferenceUseCase(get())
        }
        factory {
            SetLanguagePreferenceUseCase(get(), get())
        }
        factory {
            GetLanguageScreenStringResourcesUseCase()
        }
    }