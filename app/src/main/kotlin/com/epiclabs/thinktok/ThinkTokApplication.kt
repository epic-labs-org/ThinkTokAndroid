package com.epiclabs.thinktok

import android.app.Application
import com.epiclabs.thinktok.main.domain.di.mainDomainModule
import com.epiclabs.thinktok.main.presentation.di.mainModule
import com.epiclabs.thinktok.main.repository.di.somethingRepositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class ThinkTokApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger()
            androidContext(this@ThinkTokApplication)

            addMainModules()
        }
    }

    // TODO("It's a test module! it will be removed as part of #30")
    private fun KoinApplication.addMainModules() {
        modules(
            mainModule,
            mainDomainModule,
            somethingRepositoryModule,
        )
    }
}