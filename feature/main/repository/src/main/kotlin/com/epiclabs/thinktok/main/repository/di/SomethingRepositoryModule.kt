package com.epiclabs.thinktok.main.repository.di

import com.epiclabs.thinktok.main.domain.api.SomethingRepository
import com.epiclabs.thinktok.main.repository.SomethingRepositoryImpl
import org.koin.dsl.module

// TODO("It's a test module! it will be removed as part of #30")
val somethingRepositoryModule =
    module {
        factory<SomethingRepository> {
            SomethingRepositoryImpl()
        }
    }