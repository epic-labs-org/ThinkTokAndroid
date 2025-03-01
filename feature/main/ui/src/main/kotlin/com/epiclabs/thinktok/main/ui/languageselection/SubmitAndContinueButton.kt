package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun SubmitAndContinueButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = buttonText)
    }
}

@Preview
@Composable
internal fun PreviewSubmitAndContinueButton() {
    SubmitAndContinueButton(onClick = {}, buttonText = "Submit and continue")
}
