package com.epiclabs.thinktok.data.local.source

import com.epiclabs.thinktok.data.local.dao.UserPreferenceDao
import com.epiclabs.thinktok.data.local.mapper.toUserPreference
import com.epiclabs.thinktok.data.local.mapper.toUserPreferenceEntity
import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.repository.api.UserPreferenceLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class UserPreferenceLocalDataSourceImpl(private val userPreferenceDao: UserPreferenceDao) :
    UserPreferenceLocalDataSource {
    override suspend fun insertUserPreference(userPreference: UserPreference) {
        userPreferenceDao.insertUserPreference(userPreference.toUserPreferenceEntity())
    }

    override fun getUserPreference(): Flow<UserPreference?> {
        return userPreferenceDao.getUserPreference().map { it?.toUserPreference() }
    }
}