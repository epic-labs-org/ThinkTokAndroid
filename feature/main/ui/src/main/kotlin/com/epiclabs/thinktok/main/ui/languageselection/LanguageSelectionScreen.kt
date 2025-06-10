package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epiclabs.thinktok.designsystem.component.ThinkTokTemplate
import com.epiclabs.thinktok.designsystem.component.cardStyle
import com.epiclabs.thinktok.designsystem.theme.ThinkTokTheme
import com.epiclabs.thinktok.main.ui.R
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
    ThinkTokTemplate {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .cardStyle()
                    .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.size(80.dp),
                contentDescription = "",
                painter = painterResource(R.drawable.language_header),
            )
            Text(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                style = MaterialTheme.typography.titleMedium,
                text = chooseLanguageHint,
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleSmall,
                text = yourLanguageLabel,
            )
            Spacer(modifier = Modifier.height(5.dp))
            LanguageDropdown(
                languages = yourLanguages,
                placeholder = originLanguage,
                onLanguageSelected = onOriginLanguageSelected,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleSmall,
                text = languageToLearnLabel,
            )
            Spacer(modifier = Modifier.height(5.dp))

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
}

@Composable
internal fun LanguageSelectionScreen(
    viewModel: LanguageSelectionViewModel = koinViewModel(),
    onSubmitClick: () -> Unit = { },
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
    ThinkTokTheme {
        LanguageSelectionScreen(
            LanguageSelectionUiModel(
                yourLanguages = listOf("Persian"),
                originLanguage = "Persian",
                languagesToLearn = listOf("English"),
                learningLanguage = "English",
                chooseLanguageHint = "Let’s get started! \uD83C\uDF0D\nChoose your native language and the language you want to learn:",
                yourLanguageLabel = "My native language",
                languageToLearnLabel = "I want to learn",
                buttonText = "Let’s go!",
                languagesToLearnEnabled = false,
            ),
        )
    }
}