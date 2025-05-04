package com.epiclabs.thinktok.data.local.di

import android.app.Application
import androidx.room.Room
import com.epiclabs.thinktok.data.local.dao.UserPreferenceDao
import com.epiclabs.thinktok.data.local.dao.WordDao
import com.epiclabs.thinktok.data.local.dao.WordReactionDao
import com.epiclabs.thinktok.data.local.db.AppDatabase
import com.epiclabs.thinktok.data.local.source.UserPreferenceLocalDataSourceImpl
import com.epiclabs.thinktok.data.local.source.WordLocalDataSourceImpl
import com.epiclabs.thinktok.main.repository.api.UserPreferenceLocalDataSource
import com.epiclabs.thinktok.main.repository.api.WordLocalDataSource
import org.koin.dsl.module

val dataModule =
    module {
        single { provideDatabase(get()) }
        single { provideUserPreferenceDao(get()) }
        single { provideWordDao(get()) }
        single { provideWordReactionDao(get()) }

        single<UserPreferenceLocalDataSource> { UserPreferenceLocalDataSourceImpl(get()) }
        single<WordLocalDataSource> { WordLocalDataSourceImpl(get(), get()) }
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

private fun provideWordDao(database: AppDatabase): WordDao {
    return database.wordDao()
}

private fun provideWordReactionDao(database: AppDatabase): WordReactionDao {
    return database.wordReactionDao()
}