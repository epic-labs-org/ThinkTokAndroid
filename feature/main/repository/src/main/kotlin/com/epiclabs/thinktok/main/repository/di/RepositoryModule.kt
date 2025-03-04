package com.epiclabs.thinktok.main.repository.di

import com.epiclabs.thinktok.core.ioDispatcherQualifier
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import com.epiclabs.thinktok.main.repository.UserPreferenceRepositoryImpl
import org.koin.dsl.module

val repositoryModule =
    module {
        single<UserPreferenceRepository> {
            UserPreferenceRepositoryImpl(
                ioDispatcher = get(ioDispatcherQualifier),
                userPreferenceLocalDataSource = get(),
            )
        }
    }