package zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.model.Emoji
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiReactionBubbleColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SelectedEmojiContainer(
    selectedEmojis: List<Emoji>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(EmojiReactionBubbleColors.surface50)
            .padding(vertical = 14.dp, horizontal = 18.dp)
            .animateContentSize()
    ) {
        Text(
            text = "Iʼll send the draft tonight.",
            color = EmojiReactionBubbleColors.onSurface,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(6.dp))

        FlowRow(
            modifier = Modifier.width(210.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            selectedEmojis.forEach { emoji ->
                EmojiContainerItem(emoji = emoji)
            }
        }
    }
}