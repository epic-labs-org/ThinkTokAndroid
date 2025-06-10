package com.epiclabs.thinktok.main.domain

class GetLanguageScreenStringResourcesUseCase() {
    operator fun invoke() =
        Response(
            supportedOriginLanguages = listOf("Persian", "English"),
            originLanguagePlaceHolder = "Persian",
            supportedLearningLanguages = listOf("English", "Persian", "Spanish", "French"),
            learningLanguagePlaceHolder = "English",
            chooseLanguageHint = "Let’s get started! \uD83C\uDF0D \nChoose your native language and the language you want to learn:",
            yourLanguageLabel = "My native language",
            languageToLearnLabel = "What language do you want to learn",
            buttonText = "Submit and continue",
        )

    data class Response(
        val supportedOriginLanguages: List<String>,
        val chooseLanguageHint: String,
        val originLanguagePlaceHolder: String,
        val supportedLearningLanguages: List<String>,
        val learningLanguagePlaceHolder: String,
        val yourLanguageLabel: String,
        val languageToLearnLabel: String,
        val buttonText: String,
    )
}