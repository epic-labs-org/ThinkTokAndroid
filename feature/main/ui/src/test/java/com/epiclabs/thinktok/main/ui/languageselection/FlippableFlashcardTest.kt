package com.epiclabs.thinktok.main.ui.languageselection

import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import com.epiclabs.thinktok.main.ui.main.FLIPPABLE_FLASHCARD_BACK_SIDE_TEST_TAG
import com.epiclabs.thinktok.main.ui.main.FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG
import com.epiclabs.thinktok.main.ui.main.FlippableFlashcard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class FlippableFlashcardTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val word = "Front"
    private val translation = "Back"

    @Test
    fun `Given flippableFlashcard When initialState Then check word is displayed`() {
        composeTestRule.setContent {
            FlippableFlashcard(
                front = { Text(text = word) },
                back = { Text(text = translation) },
            )
        }
        // Check if initially the word is displayed but the translation is not.
        composeTestRule.onNode(hasText(text = word)).assertIsDisplayed()
        composeTestRule.onNode(hasText(text = translation)).assertIsNotDisplayed()
    }

    // fun testSwipeRight_translationIsDisplayed() {
    @Test
    fun `Given flippableFlashcard When swipe right Then check translation is displayed`() {
        composeTestRule.setContent {
            FlippableFlashcard(
                front = { Text(text = word) },
                back = { Text(text = translation) },
            )
        }
        // Flip the card with a swipe right gesture
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG).performTouchInput { swipeRight() }

        // Check if the translation is displayed after swiping to the right.
        composeTestRule.onNode(hasText(text = translation)).assertIsDisplayed()

        // Verify that the word does not appear after swiping to the right.
        composeTestRule.onNode(hasText(text = word)).assertIsNotDisplayed()
    }

    @Test
    fun `Given flippableFlashcard When initialState Then check front side is visible`() {
        composeTestRule.setContent {
            FlippableFlashcard(
                front = { Text(text = word) },
                back = { Text(text = translation) },
            )
        }
        // Check if the front side is visible
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG).assertExists()

        // Check if the back side is not visible
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_BACK_SIDE_TEST_TAG).assertDoesNotExist()
    }

    @Test
    fun `Given flippableFlashcard When swipe right Then check back side is visible`() {
        composeTestRule.setContent {
            FlippableFlashcard(
                front = { Text(text = word) },
                back = { Text(text = translation) },
            )
        }

        // Flip the card with a swipe right gesture
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG).performTouchInput { swipeRight() }
        // Check if the back side of the flashcard is visible
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_BACK_SIDE_TEST_TAG).assertExists()
        // Check if the front side of the flashcard is not visible
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG).assertDoesNotExist()
    }

    @Test
    fun `Given flippableFlashcard When swipe right and left Then check front side is visible`() {
        composeTestRule.setContent {
            FlippableFlashcard(
                front = { Text(text = word) },
                back = { Text(text = translation) },
            )
        }

        // Flip the card with a swipe right gesture
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG).performTouchInput { swipeRight() }

        // Flip the card with a swipe to left gesture to bring it back to the initial state
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_BACK_SIDE_TEST_TAG).performTouchInput { swipeLeft() }

        // Check if the front side of the flashcard is visible
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG).assertExists()
        // Check if the back side of the flashcard is not visible
        composeTestRule.onNodeWithTag(FLIPPABLE_FLASHCARD_BACK_SIDE_TEST_TAG).assertDoesNotExist()
    }
}