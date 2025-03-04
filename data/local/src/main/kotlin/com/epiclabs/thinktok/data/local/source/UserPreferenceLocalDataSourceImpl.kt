package com.epiclabs.thinktok.data.local.source

import com.epiclabs.thinktok.data.local.dao.UserPreferenceDao
import com.epiclabs.thinktok.data.local.mapper.toUserPreference
import com.epiclabs.thinktok.data.local.mapper.toUserPreferenceEntity
import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.repository.api.UserPreferenceLocalDataSource

internal class UserPreferenceLocalDataSourceImpl(private val userPreferenceDao: UserPreferenceDao) :
    UserPreferenceLocalDataSource {
    override suspend fun insertUserPreference(userPreference: UserPreference) {
        userPreferenceDao.insertUserPreference(userPreference.toUserPreferenceEntity())
    }

    override suspend fun getUserPreference(): UserPreference? {
        return userPreferenceDao.getUserPreference()?.toUserPreference()
    }
}