package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LanguageDropdown(
    languages: List<String>,
    enabled: Boolean = true,
    placeholder: String,
    onLanguageSelected: (String) -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf(placeholder) }

    ExposedDropdownMenuBox(
        modifier = Modifier.fillMaxWidth(),
        expanded = expanded,
        onExpandedChange = {
            if (enabled) {
                expanded = !expanded
            }
        },
    ) {
        TextField(
            value = selectedLanguage,
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier =
                Modifier
                    .testTag("LanguageDropdownTextField")
                    .menuAnchor()
                    .fillMaxWidth(),
        )

        ExposedDropdownMenu(
            modifier = Modifier.fillMaxWidth().testTag("LanguageDropdownMenu"),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth().testTag("LanguageDropdownMenuItem-$language"),
                    text = { Text(text = language) },
                    onClick = {
                        selectedLanguage = language
                        expanded = false
                        onLanguageSelected(language)
                    },
                )
            }
        }
    }
}

@Preview
@Composable
internal fun PreviewLanguageDropdown() {
    LanguageDropdown(listOf("Persian"), placeholder = "Persian")
}