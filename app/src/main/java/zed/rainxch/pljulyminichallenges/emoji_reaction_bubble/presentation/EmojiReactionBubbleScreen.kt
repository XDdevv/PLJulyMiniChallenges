package zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.components.SelectedEmojiContainer
import zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.components.EmojisBar
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiReactionBubbleColors

@Composable
fun EmojiReactionBubbleScreenRoot() {
    val viewModel = viewModel<EmojiReactionBubbleViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    EmojiReactionBubbleScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun EmojiReactionBubbleScreen(
    state: EmojiReactionBubbleUiState,
    onAction: (EmojiReactionBubbleActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(EmojiReactionBubbleColors.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmojisBar(
                emojis = state.emojis,
                onEmojiSelected = { emoji ->
                    onAction(EmojiReactionBubbleActions.OnEmojiClick(emoji))
                }
            )

            Spacer(Modifier.height(8.dp))

            SelectedEmojiContainer(selectedEmojis = state.selectedEmojis)
        }
    }
}

@Preview
@Composable
private fun EmojiReactionBubbleScreenPreview() {
    EmojiReactionBubbleScreen(
        state = EmojiReactionBubbleUiState(),
        onAction = {

        }
    )
}