package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable

@Composable
internal fun WordPager(
    wordContent: PagerScopeContent = { pageNumber ->
        WordContent("Word $pageNumber", "Smaller Text Below")
    },
) {
    val pageCount = Int.MAX_VALUE
    val pagerState =
        rememberPagerState(
            initialPage = 0,
            pageCount = { pageCount },
        )

    VerticalPager(state = pagerState) { page ->
        wordContent(this, page)
    }
}