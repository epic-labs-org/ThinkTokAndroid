package com.epiclabs.thinktok.main.repository.api

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import kotlinx.coroutines.flow.Flow

interface UserPreferenceLocalDataSource {
    suspend fun insertUserPreference(userPreference: UserPreference)

    fun getUserPreference(): Flow<UserPreference?>
}