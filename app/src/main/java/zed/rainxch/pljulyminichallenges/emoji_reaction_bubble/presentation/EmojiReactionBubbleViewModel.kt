package zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.model.Emoji

data class EmojiReactionBubbleUiState(
    val emojis: List<String> = listOf(
        "\uD83D\uDC4D",
        "\uD83D\uDE02",
        "\uD83D\uDE2E",
        "❤",
        "\uD83D\uDE22"
    ),
    val selectedEmojis: List<Emoji> = emptyList(),
)

sealed interface EmojiReactionBubbleActions {
    data class OnEmojiClick(val emoji: String) : EmojiReactionBubbleActions
}

class EmojiReactionBubbleViewModel : ViewModel() {
    private val _state = MutableStateFlow(EmojiReactionBubbleUiState())
    val state = _state.asStateFlow()

    fun onAction(action: EmojiReactionBubbleActions) {
        when (action) {
            is EmojiReactionBubbleActions.OnEmojiClick -> {
                handleEmojiClick(emoji = action.emoji)
            }
        }
    }

    private fun handleEmojiClick(emoji: String) {
        val selectedEmoji = _state.value.selectedEmojis.find { it.emoji == emoji }
        if (selectedEmoji != null) {
            val selectedEmojiIndex = _state.value.selectedEmojis.indexOf(selectedEmoji)
            val newEmoji = selectedEmoji.copy(count = selectedEmoji.count + 1)
            val newEmojiList = _state.value.selectedEmojis.toMutableList()
            newEmojiList.set(index = selectedEmojiIndex, element = newEmoji)
            _state.update { it.copy(selectedEmojis = newEmojiList) }
        } else {
            val newEmojiList = _state.value.selectedEmojis.toMutableList()
            newEmojiList.add(Emoji(emoji = emoji, count = 1))
            _state.update { it.copy(selectedEmojis = newEmojiList) }
        }
    }
}