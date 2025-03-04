package com.epiclabs.thinktok.main.domain

import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class GetLanguagePreferenceUseCase(
    private val ioDispatcher: CoroutineDispatcher,
    private val userPreferenceRepository: UserPreferenceRepository,
) {
    suspend operator fun invoke() =
        withContext(ioDispatcher) {
            userPreferenceRepository.getLanguagePreference()
        }
}