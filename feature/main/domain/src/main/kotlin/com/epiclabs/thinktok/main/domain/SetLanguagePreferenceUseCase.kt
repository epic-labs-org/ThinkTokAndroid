package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import kotlinx.coroutines.flow.first

class SetLanguagePreferenceUseCase(
    private val getLanguagePreferenceUseCase: GetLanguagePreferenceUseCase,
    private val userPreferenceRepository: UserPreferenceRepository,
) {
    suspend operator fun invoke(
        learningLanguage: String,
        originLanguage: String,
    ) {
        getLanguagePreferenceUseCase().first() ?: UserPreference(
            learningLanguage = "",
            originLanguage = "",
        ).copy(
            learningLanguage = learningLanguage,
            originLanguage = originLanguage,
        ).also {
            userPreferenceRepository.insertUserPreference(it)
        }
    }
}