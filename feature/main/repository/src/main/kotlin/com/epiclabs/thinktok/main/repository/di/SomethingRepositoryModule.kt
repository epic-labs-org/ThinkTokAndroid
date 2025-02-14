package com.epiclabs.thinktok.main.repository.di

import com.epiclabs.thinktok.main.domain.api.SomethingRepository
import com.epiclabs.thinktok.main.repository.SomethingRepositoryImpl
import org.koin.dsl.module

val somethingRepositoryModule = module {
    factory<SomethingRepository> {
        SomethingRepositoryImpl()
    }
}