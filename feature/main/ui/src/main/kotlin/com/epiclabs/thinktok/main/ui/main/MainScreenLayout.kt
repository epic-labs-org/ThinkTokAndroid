package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

typealias BoxScopeToUnit = @Composable BoxScope.() -> Unit
typealias PagerScopeContent = @Composable PagerScope.(page: Int) -> Unit

@Composable
fun MainScreenLayout(
    modifier: Modifier = Modifier,
    languageSwitcherContent: BoxScopeToUnit = {},
    wordContent: BoxScopeToUnit = {},
) {
    Box(modifier = modifier.fillMaxSize()) {
        languageSwitcherContent()
        wordContent()
    }
}

@Composable
@Preview(showBackground = true)
private fun MainScreenLayoutPreview() {
    MainScreenLayout(
        languageSwitcherContent = {
            LanguageSwitcherIcon(
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
            )
        },
        wordContent = {
            WordPager()
        },
    )
}
