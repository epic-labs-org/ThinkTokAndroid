package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule

internal class LanguageDropdownTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun languageDropdown_initialState() {
        val languages = listOf("English", "Spanish", "French")
        val selectedLanguage = "English"

        composeTestRule.setContent {
            LanguageDropdown(
                languages = languages,
                placeholder = selectedLanguage,
            )
        }

        // Check if the dropdown is initially closed
        composeTestRule.onNodeWithTag("LanguageDropdownMenu").assertDoesNotExist()

        // Check if the selected language is displayed in the text field
        composeTestRule.onNodeWithTag("LanguageDropdownTextField").assertTextEquals(selectedLanguage)
    }

    @Test
    fun languageDropdown_expandAndSelect() {
        val languages = listOf("English", "Spanish", "French")
        val selectedLanguage = "English"
        var capturedSelectedLanguage: String? = null

        composeTestRule.setContent {
            LanguageDropdown(
                languages = languages,
                placeholder = selectedLanguage,
                onLanguageSelected = { capturedSelectedLanguage = it },
            )
        }

        // Expand the dropdown
        composeTestRule.onNodeWithTag("LanguageDropdownTextField").performClick()

        // Check if the dropdown menu is displayed
        composeTestRule.onNodeWithTag("LanguageDropdownMenu").assertIsDisplayed()

        // Select a language
        composeTestRule.onNodeWithTag("LanguageDropdownMenuItem-Spanish").performClick()

        // Check if the selected language is updated
        assert(capturedSelectedLanguage == "Spanish")

        // Check if the selected language is displayed in the text field
        composeTestRule.onNodeWithTag("LanguageDropdownTextField").assertTextEquals("Spanish")

        // Check if the dropdown is closed after selection
        composeTestRule.onNodeWithTag("LanguageDropdownMenu").assertDoesNotExist()
    }

    @Test
    fun languageDropdown_allLanguagesDisplayed() {
        val languages = listOf("English", "Spanish", "French")
        val selectedLanguage = "English"

        composeTestRule.setContent {
            LanguageDropdown(
                languages = languages,
                placeholder = selectedLanguage,
            )
        }

        // Expand the dropdown
        composeTestRule.onNodeWithTag("LanguageDropdownTextField").performClick()

        // Check if all languages are displayed
        languages.forEach { language ->
            composeTestRule.onNodeWithTag("LanguageDropdownMenuItem-$language").assertIsDisplayed()
        }
    }
}