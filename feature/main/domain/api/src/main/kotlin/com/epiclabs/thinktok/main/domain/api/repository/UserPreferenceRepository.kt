package com.epiclabs.thinktok.main.domain.api.repository

import com.epiclabs.thinktok.main.domain.api.model.UserPreference

interface UserPreferenceRepository {
    suspend fun getUserPreference(): UserPreference?

    suspend fun insertUserPreference(userPreference: UserPreference)
}