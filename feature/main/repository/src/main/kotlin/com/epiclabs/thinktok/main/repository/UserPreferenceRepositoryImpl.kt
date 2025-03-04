package com.epiclabs.thinktok.main.repository

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import com.epiclabs.thinktok.main.repository.api.UserPreferenceLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

internal class UserPreferenceRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher,
    private val userPreferenceLocalDataSource: UserPreferenceLocalDataSource,
) :
    UserPreferenceRepository {
    override fun getUserPreference() =
        userPreferenceLocalDataSource
            .getUserPreference()
            .flowOn(ioDispatcher)

    override suspend fun insertUserPreference(userPreference: UserPreference) {
        return withContext(ioDispatcher) {
            userPreferenceLocalDataSource.insertUserPreference(userPreference)
        }
    }
}