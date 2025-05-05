package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.epiclabs.thinktok.main.presentation.main.model.WordUiModel

@Composable
internal fun WordPager(pagingItems: LazyPagingItems<WordUiModel>) {
    val pagerState =
        rememberPagerState(
            initialPage = 0,
            pageCount = { pagingItems.itemCount },
        )

    VerticalPager(state = pagerState) { page ->
        pagingItems[page]?.let { word ->
            WordContent(word.word, word.translation)
        }
    }
}