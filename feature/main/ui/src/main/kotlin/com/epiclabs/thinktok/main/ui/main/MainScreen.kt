package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.epiclabs.thinktok.main.presentation.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
) {
    Column(modifier = modifier) {
        Text("This is Compose from ${viewModel.getSomething()}")
    }
}