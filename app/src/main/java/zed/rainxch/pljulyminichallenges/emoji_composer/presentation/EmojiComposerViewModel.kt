package zed.rainxch.pljulyminichallenges.emoji_composer.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EmojiComposerUiState(
    val emojis: List<String> = listOf(
        "\uD83D\uDE02",
        "\uD83D\uDE0D",
        "\uD83D\uDC7B",
        "\uD83D\uDC96",
        "\uD83D\uDE2D"
    ),
    val input: String = "",
    val scaledIndex: Int = 0,
    val isDragging: Boolean = false,
)

sealed interface EmojiComposerActions {
    data class StartDrag(val index: Int) : EmojiComposerActions
    data class UpdateDrag(val index: Int) : EmojiComposerActions
    data class EndDrag(val sticker: String) : EmojiComposerActions
}

class EmojiComposerViewModel : ViewModel() {
    private val _state = MutableStateFlow(EmojiComposerUiState())
    val state = _state.asStateFlow()

    fun onAction(action: EmojiComposerActions) {
        when (action) {
            is EmojiComposerActions.EndDrag -> {
                _state.update { uiState ->
                    uiState.copy(
                        scaledIndex = -1,
                        input = uiState.input + action.sticker
                    )
                }
            }

            is EmojiComposerActions.StartDrag -> {
                if (action.index != _state.value.scaledIndex) {
                    _state.update { it.copy(scaledIndex = action.index) }
                }
            }

            is EmojiComposerActions.UpdateDrag -> {
                _state.update { it.copy(scaledIndex = action.index) }

            }
        }
    }

}