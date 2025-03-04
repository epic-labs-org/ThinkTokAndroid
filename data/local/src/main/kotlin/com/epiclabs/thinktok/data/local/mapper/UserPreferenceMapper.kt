package com.epiclabs.thinktok.data.local.mapper

import com.epiclabs.thinktok.data.local.entity.DEFAULT_USER_ID
import com.epiclabs.thinktok.data.local.entity.UserPreferenceEntity
import com.epiclabs.thinktok.main.domain.api.model.UserPreference

internal fun UserPreferenceEntity.toUserPreference(): UserPreference {
    return UserPreference(
        learningLanguage = learningLanguage,
        originLanguage = originLanguage,
    )
}

internal fun UserPreference.toUserPreferenceEntity(): UserPreferenceEntity {
    return UserPreferenceEntity(
        id = DEFAULT_USER_ID,
        learningLanguage = learningLanguage,
        originLanguage = originLanguage,
    )
}