package com.epiclabs.thinktok.main.domain.api.repository

import com.epiclabs.thinktok.main.domain.api.model.LanguagePreference

interface UserPreferenceRepository {
    fun getLanguagePreference(): LanguagePreference
}