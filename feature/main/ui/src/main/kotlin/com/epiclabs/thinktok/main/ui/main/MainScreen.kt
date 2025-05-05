package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.epiclabs.thinktok.main.presentation.main.MainUiIntent.OnSetLanguageClicked
import com.epiclabs.thinktok.main.presentation.main.MainUiState
import com.epiclabs.thinktok.main.presentation.main.MainViewModel
import com.epiclabs.thinktok.main.presentation.main.model.WordUiModel
import com.epiclabs.thinktok.main.ui.languageselection.LanguageSelectionScreen
import kotlinx.coroutines.flow.flowOf
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val words: LazyPagingItems<WordUiModel> = viewModel.words.collectAsLazyPagingItems()

    MainScreen(
        modifier = modifier,
        uiState = uiState,
        pagingItems = words,
        onLanguageSetClicked = {
            viewModel.onUiIntent(OnSetLanguageClicked)
        },
    )
}

@Composable
private fun MainScreen(
    modifier: Modifier = Modifier,
    uiState: MainUiState,
    pagingItems: LazyPagingItems<WordUiModel>,
    onLanguageSetClicked: () -> Unit = {},
) {
    Column(modifier = modifier) {
        when {
            uiState.isLoading -> {
                Text("Loading...")
            }

            !uiState.hideLanguageSelectionScreen -> {
                LanguageSelectionScreen()
            }

            else -> {
                MainScreenLayout(
                    languageSwitcherContent = {
                        LanguageSwitcherIcon(
                            onLanguageSetClicked = onLanguageSetClicked,
                            modifier =
                                Modifier
                                    .zIndex(1f)
                                    .align(Alignment.TopEnd)
                                    .padding(16.dp),
                        )
                    },
                    wordContent = {
                        WordPager(pagingItems)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(
        uiState =
            MainUiState(
                hideLanguageSelectionScreen = true,
                isLoading = false,
            ),
        pagingItems = flowOf(PagingData.empty<WordUiModel>()).collectAsLazyPagingItems(),
    )
}