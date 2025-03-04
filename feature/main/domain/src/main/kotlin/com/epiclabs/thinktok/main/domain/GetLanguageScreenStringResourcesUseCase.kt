package com.epiclabs.thinktok.main.domain

class GetLanguageScreenStringResourcesUseCase() {
    suspend operator fun invoke() =
        Response(
            supportedOriginLanguages = listOf("Persian", "English"),
            originLanguagePlaceHolder = "Persian",
            supportedLearningLanguages = listOf("English", "Persian", "Spanish", "French"),
            learningLanguagePlaceHolder = "English",
            yourLanguageLabel = "Your Language",
            languageToLearnLabel = "What language do you want to learn",
            buttonText = "Submit and continue",
        )

    data class Response(
        val supportedOriginLanguages: List<String>,
        val originLanguagePlaceHolder: String,
        val supportedLearningLanguages: List<String>,
        val learningLanguagePlaceHolder: String,
        val yourLanguageLabel: String,
        val languageToLearnLabel: String,
        val buttonText: String,
    )
}