package zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun EmojiBarItem(
    emoji: String,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Text(
        text = emoji,
        fontSize = 24.sp,
        fontFamily = urbanistFontFamily,
        fontWeight = FontWeight.Normal,
        modifier = modifier
            .padding(4.dp)
            .clickable(onClick = onItemClick)
    )
}

@Preview
@Composable
private fun EmojiBarItemPreview() {
    EmojiBarItem(
        emoji = "👍",
        {}
    )
}