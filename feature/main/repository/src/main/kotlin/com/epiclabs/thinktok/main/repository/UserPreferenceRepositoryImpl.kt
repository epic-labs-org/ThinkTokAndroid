package com.epiclabs.thinktok.main.repository

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import com.epiclabs.thinktok.main.repository.api.UserPreferenceLocalDataSource

internal class UserPreferenceRepositoryImpl(private val userPreferenceLocalDataSource: UserPreferenceLocalDataSource) : UserPreferenceRepository {
    override suspend fun getUserPreference(): UserPreference? {
        return userPreferenceLocalDataSource.getUserPreference()
    }

    override suspend fun insertUserPreference(userPreference: UserPreference) {
        return userPreferenceLocalDataSource.insertUserPreference(userPreference)
    }
}