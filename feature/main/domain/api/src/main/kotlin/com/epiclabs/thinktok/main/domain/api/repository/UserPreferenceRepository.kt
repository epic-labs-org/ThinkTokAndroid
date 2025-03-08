package com.epiclabs.thinktok.main.domain.api.repository

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import kotlinx.coroutines.flow.Flow

interface UserPreferenceRepository {
    fun getUserPreference(): Flow<UserPreference?>

    suspend fun insertUserPreference(userPreference: UserPreference)
}