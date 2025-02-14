package com.epiclabs.thinktok.main.domain.di

import com.epiclabs.thinktok.main.domain.GetSomethingUseCase
import org.koin.dsl.module

val mainDomainModule= module {
    factory {
        GetSomethingUseCase(get())
    }
}