package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epiclabs.thinktok.designsystem.theme.ThinkTokTheme
import com.epiclabs.thinktok.main.ui.R

private const val TEST_TAG_LANGUAGE_DROPDOWN_TEXT_FIELD = "LanguageDropdownTextField"
private const val TEST_TAG_LANGUAGE_DROPDOWN_MENU = "LanguageDropdownMenu"
private const val TEST_TAG_LANGUAGE_DROPDOWN_MENU_ITEM = "LanguageDropdownMenuItem-%s"

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
            shape = MaterialTheme.shapes.large,
            readOnly = true,
            enabled = enabled,
            colors =
                TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
            leadingIcon = {
                Image(
                    painter = painterResource(R.drawable.language),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp),
                )
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier =
                Modifier
                    .testTag(TEST_TAG_LANGUAGE_DROPDOWN_TEXT_FIELD)
                    .menuAnchor()
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerLow,
                        shape = MaterialTheme.shapes.large,
                    ),
        )

        ExposedDropdownMenu(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .testTag(TEST_TAG_LANGUAGE_DROPDOWN_MENU),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            languages.forEach { language ->
                DropdownMenuItem(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .testTag(TEST_TAG_LANGUAGE_DROPDOWN_MENU_ITEM.format(language)),
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
    ThinkTokTheme {
        LanguageDropdown(listOf("Persian"), placeholder = "Persian")
    }
}