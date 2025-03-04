package com.epiclabs.thinktok.data.local.di

import android.app.Application
import androidx.room.Room
import com.epiclabs.thinktok.data.local.dao.UserPreferenceDao
import com.epiclabs.thinktok.data.local.db.AppDatabase
import com.epiclabs.thinktok.data.local.source.UserPreferenceLocalDataSourceImpl
import com.epiclabs.thinktok.main.repository.api.UserPreferenceLocalDataSource
import org.koin.dsl.module

val dataModule =
    module {
        single { provideDatabase(get()) }
        single { provideUserPreferenceDao(get()) }
        single<UserPreferenceLocalDataSource> { UserPreferenceLocalDataSourceImpl(get()) }
    }

private fun provideDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "app_database",
    ).build()
}

private fun provideUserPreferenceDao(database: AppDatabase): UserPreferenceDao {
    return database.userPreferenceDao()
}