package com.epiclabs.thinktok.main.repository.api

import com.epiclabs.thinktok.main.domain.api.model.UserPreference

interface UserPreferenceLocalDataSource {
    suspend fun insertUserPreference(userPreference: UserPreference)

    suspend fun getUserPreference(): UserPreference?
}