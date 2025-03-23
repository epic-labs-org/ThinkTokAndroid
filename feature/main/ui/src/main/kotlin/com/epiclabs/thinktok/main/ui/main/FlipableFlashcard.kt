package com.epiclabs.thinktok.main.ui.main

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

const val FLIPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG = "FlipableFlashcardFrontSide"
const val FLIPABLE_FLASHCARD_BACK_SIDE_TEST_TAG = "FlipableFlashcardBackSide"

@Composable
internal fun FlipableFlashcard(
    front: @Composable () -> Unit,
    back: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFlipped by remember { mutableStateOf(false) }
    var rotationY by remember { mutableStateOf(0f) }

    val animatedRotationY by animateFloatAsState(
        targetValue = rotationY,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "rotationY",
    )
    val density = LocalDensity.current.density

    BoxWithConstraints(
        modifier = modifier.padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures { change, dragAmount ->
                            change.consume()
                            if (dragAmount.absoluteValue > 10) {
                                if (!isFlipped && dragAmount > 0) {
                                    // Swipe right to flip to back
                                    rotationY = 180f
                                    isFlipped = true
                                } else if (isFlipped && dragAmount < 0) {
                                    // Swipe left to flip to front
                                    rotationY = 0f
                                    isFlipped = false
                                }
                            }
                        }
                    }
                    .graphicsLayer {
                        this.rotationY = animatedRotationY
                        cameraDistance = 8 * density
                    },
        ) {
            if (animatedRotationY <= 90f) {
                // Front of the card
                Card(
                    modifier =
                        Modifier
                            .testTag(FLIPABLE_FLASHCARD_FRONT_SIDE_TEST_TAG)
                            .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    front()
                }
            } else {
                // Back of the card
                Card(
                    modifier =
                        Modifier
                            .testTag(FLIPABLE_FLASHCARD_BACK_SIDE_TEST_TAG)
                            .fillMaxWidth()
                            .graphicsLayer {
                                this.rotationY = 180f
                            },
                    shape = RoundedCornerShape(16.dp),
                ) {
                    back()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FlipableFlashcardPreview() {
    val word = "Example Word"
    val translation = "Example Translation"
    FlipableFlashcard(
        modifier =
            Modifier
                .fillMaxSize(),
        front = {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.primaryContainer),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = word,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                )
            }
        },
        back = {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = translation,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                )
            }
        },
    )
}
