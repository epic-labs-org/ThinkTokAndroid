package com.epiclabs.thinktok.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epiclabs.thinktok.designsystem.R

@Composable
fun ThinkTokTemplate(
    modifier: Modifier = Modifier,
    rightIcon: Painter? = null,
    onRightIconClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Header(
            appIcon = painterResource(R.drawable.app_header_icon),
            rightIcon = rightIcon,
            onRightIconClick = onRightIconClick,
        )
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
        ) {
            content()
        }
    }
}

@Composable
private fun Header(
    appIcon: Painter,
    rightIcon: Painter? = null,
    onRightIconClick: (() -> Unit)? = null,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color(0xFF0078D9)),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = appIcon,
                contentDescription = "App Icon",
                modifier = Modifier.size(24.dp),
            )

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "ThinkTok",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            if (rightIcon != null && onRightIconClick != null) {
                Image(
                    painter = rightIcon,
                    contentDescription = "Right Icon",
                    modifier = Modifier.size(24.dp).clickable { onRightIconClick() },
                )
            } else {
                Spacer(modifier = Modifier.size(24.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun ThinkTokScreenTemplatePreview() {
    ThinkTokTemplate {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Preview Content", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun ThinkTokScreenTemplateWithRightIconPreview() {
    ThinkTokTemplate(
        rightIcon = painterResource(R.drawable.app_header_icon),
        onRightIconClick = {},
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Preview Content", style = MaterialTheme.typography.bodyLarge)
        }
    }
}