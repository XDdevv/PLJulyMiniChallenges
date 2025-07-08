package zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.model.Emoji
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiReactionBubbleColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun EmojiContainerItem(
    emoji: Emoji,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(EmojiReactionBubbleColors.blue12)
            .padding(vertical = 6.dp, horizontal = 10.dp)
            .animateContentSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = emoji.emoji,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Normal
        )

        if (emoji.count > 1) {
            Text(
                text = emoji.count.toString(),
                color = EmojiReactionBubbleColors.onSurface,
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
private fun EmojiContainerItemPreview() {
    EmojiContainerItem(
        emoji = Emoji(
            emoji = "\uD83D\uDE02",
            count = 2
        )
    )
}