package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epiclabs.thinktok.main.presentation.languageselection.model.LanguageSelectionUiModel

@Composable
internal fun LanguageSelectionScreen(
    languageSelectionUiModel: LanguageSelectionUiModel,
    onYourLanguageSelected: (String) -> Unit = {},
    onLanguageToLearnSelected: (String) -> Unit = {},
    onSubmitClicked: () -> Unit = {},
) = with(languageSelectionUiModel) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
    ) {
        Text(text = yourLanguageLabel)

        Spacer(modifier = Modifier.height(16.dp))

        LanguageDropdown(
            languages = yourLanguages,
            placeholder = selectedYourLanguage,
            onLanguageSelected = onYourLanguageSelected,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = languageToLearnLabel, modifier = Modifier.padding(top = 16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        LanguageDropdown(
            languages = languagesToLearn,
            placeholder = selectedLanguageTo,
            onLanguageSelected = onLanguageToLearnSelected,
            enabled = languagesToLearn.isNotEmpty(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        SubmitAndContinueButton(
            onClick = onSubmitClicked,
            buttonText = buttonText,
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLanguageSelectionScreen() {
    LanguageSelectionScreen(
        LanguageSelectionUiModel(
            yourLanguages = listOf("Persian"),
            selectedYourLanguage = "Persian",
            languagesToLearn = listOf("English"),
            selectedLanguageTo = "English",
            yourLanguageLabel = "Your Language",
            languageToLearnLabel = "What language do you want to learn",
            buttonText = "Submit and continue",
        ),
    )
}