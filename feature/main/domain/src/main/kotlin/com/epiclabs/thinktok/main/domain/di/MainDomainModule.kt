package com.epiclabs.thinktok.main.domain.di

import com.epiclabs.thinktok.main.domain.GetSomethingUseCase
import org.koin.dsl.module

// TODO("It's a test module! it will be removed as part of #30")
val mainDomainModule =
    module {
        factory {
            GetSomethingUseCase(get())
        }
    }