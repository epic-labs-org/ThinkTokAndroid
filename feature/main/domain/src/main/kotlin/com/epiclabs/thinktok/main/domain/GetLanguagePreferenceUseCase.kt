package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.model.UserPreference
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetLanguagePreferenceUseCase(
    private val ioDispatcher: CoroutineDispatcher,
    private val userPreferenceRepository: UserPreferenceRepository,
) {
    suspend operator fun invoke() =
        withContext(ioDispatcher) {
            userPreferenceRepository.getUserPreference() ?: UserPreference(
                learningLanguage = DEFAULT_LEARNING_LANGUAGE,
                originLanguage = DEFAULT_ORIGIN_LANGUAGE,
            )
        }

    private companion object {
        private const val DEFAULT_LEARNING_LANGUAGE = "English"
        private const val DEFAULT_ORIGIN_LANGUAGE = "Persian"
    }
}