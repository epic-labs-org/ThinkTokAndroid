package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent.LearningLanguageSelected
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiIntent.OriginLanguageSelected
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionUiSingleEvent.NavigateBackIfNeeded
import com.epiclabs.thinktok.main.presentation.languageselection.LanguageSelectionViewModel
import com.epiclabs.thinktok.main.presentation.languageselection.model.LanguageSelectionUiModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
private fun LanguageSelectionScreen(
    languageSelectionUiModel: LanguageSelectionUiModel,
    onOriginLanguageSelected: (String) -> Unit = {},
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
            placeholder = originLanguage,
            onLanguageSelected = onOriginLanguageSelected,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = languageToLearnLabel, modifier = Modifier.padding(top = 16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        LanguageDropdown(
            languages = languagesToLearn,
            placeholder = learningLanguage,
            onLanguageSelected = onLanguageToLearnSelected,
            enabled = languagesToLearnEnabled,
        )

        Spacer(modifier = Modifier.height(16.dp))

        SubmitAndContinueButton(
            onClick = onSubmitClicked,
            buttonText = buttonText,
            modifier =
                Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
        )
    }
}

@Composable
internal fun LanguageSelectionScreen(
    onSubmitClick: () -> Unit = { },
    viewModel: LanguageSelectionViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is NavigateBackIfNeeded -> {
                    onSubmitClick()
                }
            }
        }
    }
    LanguageSelectionScreen(
        languageSelectionUiModel = uiState.languageSelectionUiModel,
        onOriginLanguageSelected = {
            viewModel.onUiIntent(OriginLanguageSelected(it))
        },
        onLanguageToLearnSelected = {
            viewModel.onUiIntent(LearningLanguageSelected(it))
        },
        onSubmitClicked = {
            viewModel.onUiIntent(LanguageSelectionUiIntent.SubmitClicked)
        },
    )
}

@Preview(showBackground = true)
@Composable
internal fun PreviewLanguageSelectionScreen() {
    LanguageSelectionScreen(
        LanguageSelectionUiModel(
            yourLanguages = listOf("Persian"),
            originLanguage = "Persian",
            languagesToLearn = listOf("English"),
            learningLanguage = "English",
            yourLanguageLabel = "Your Language",
            languageToLearnLabel = "What language do you want to learn",
            buttonText = "Submit and continue",
            languagesToLearnEnabled = false,
        ),
    )
}