package com.epiclabs.thinktok.main.domain.di

import com.epiclabs.thinktok.main.domain.GetLanguagePreferenceUseCase
import com.epiclabs.thinktok.main.domain.SetLanguagePreferenceUseCase
import kotlinx.coroutines.Dispatchers.IO
import org.koin.dsl.module

val ioDispatcherQualifier = org.koin.core.qualifier.named("ioDispatcher")

val mainDomainModule =
    module {
        single<kotlinx.coroutines.CoroutineDispatcher>(qualifier = ioDispatcherQualifier) {
            IO
        }
        factory {
            GetLanguagePreferenceUseCase(get(ioDispatcherQualifier), get())
        }
        factory {
            SetLanguagePreferenceUseCase(get(ioDispatcherQualifier), get(), get())
        }
    }