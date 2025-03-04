package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SetLanguagePreferenceUseCase(
    private val ioDispatcher: CoroutineDispatcher,
    private val getLanguagePreferenceUseCase: GetLanguagePreferenceUseCase,
    private val userPreferenceRepository: UserPreferenceRepository,
) {
    suspend operator fun invoke(
        learningLanguage: String,
        originLanguage: String,
    ) = withContext(ioDispatcher) {
        getLanguagePreferenceUseCase().copy(
            learningLanguage = learningLanguage,
            originLanguage = originLanguage,
        ).also {
            userPreferenceRepository.insertUserPreference(it)
        }
    }
}