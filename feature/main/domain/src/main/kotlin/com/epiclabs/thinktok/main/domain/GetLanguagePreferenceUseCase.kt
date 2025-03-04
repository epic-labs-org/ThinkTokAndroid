package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import kotlinx.coroutines.flow.Flow

class GetLanguagePreferenceUseCase(
    private val userPreferenceRepository: UserPreferenceRepository,
) {
    operator fun invoke(): Flow<UserPreference?> = userPreferenceRepository.getUserPreference()
}