package com.epiclabs.thinktok.main.repository

import com.epiclabs.thinktok.main.domain.api.model.LanguagePreference
import com.epiclabs.thinktok.main.domain.api.repository.UserPreferenceRepository

internal class UserPreferenceRepositoryImpl : UserPreferenceRepository {
    private var languagePreference: LanguagePreference = LanguagePreference("English", "Spanish")

    override fun getLanguagePreference(): LanguagePreference {
        return languagePreference
    }
}