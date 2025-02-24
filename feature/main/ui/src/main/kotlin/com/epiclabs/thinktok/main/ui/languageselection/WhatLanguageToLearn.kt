package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun WhatLanguageToLearn(label: String) {
    Text(text = label, modifier = Modifier.padding(8.dp))
}

@Preview
@Composable
internal fun PreviewWhatLanguageToLearn() {
    WhatLanguageToLearn("What language do you want to learn")
}