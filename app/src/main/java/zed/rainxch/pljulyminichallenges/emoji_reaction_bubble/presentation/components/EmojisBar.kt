package zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiReactionBubbleColors

@Composable
fun EmojisBar(
    emojis: List<String>,
    onEmojiSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(22.dp))
            .background(EmojiReactionBubbleColors.surface30)
            .border(1.dp, EmojiReactionBubbleColors.surface50, RoundedCornerShape(22.dp))
            .padding(6.dp)
    ) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(emojis) { emoji ->
                EmojiBarItem(
                    emoji = emoji,
                    onItemClick = {
                        onEmojiSelected(emoji)
                    },
                )
            }
        }
    }
}