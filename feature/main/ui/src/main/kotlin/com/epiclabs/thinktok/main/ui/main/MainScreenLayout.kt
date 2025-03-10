package com.epiclabs.thinktok.main.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun MainScreenLayout(
    modifier: Modifier = Modifier,
    languageSwitcherContent: @Composable () -> Unit,
) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (languageButton, bigText, smallText) = createRefs()

        Box(modifier = Modifier.constrainAs(languageButton) {
            end.linkTo(parent.end, margin = 16.dp)
            top.linkTo(parent.top, margin = 16.dp)
        })
        {
            languageSwitcherContent()
        }

        Text(
            text = "Big Text in Center",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier =
            Modifier.constrainAs(bigText) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
        )

        Text(
            text = "Smaller Text Below",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier =
            Modifier
                .constrainAs(smallText) {
                    top.linkTo(bigText.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = 16.dp),
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MyConstrainedLayoutPreview() {
    MainScreenLayout(languageSwitcherContent = {
        IconButton(
            onClick = { },
        ) {
            Icon(
                imageVector = Filled.Language,
                contentDescription = "Change Language",
            )
        }
    })
}
