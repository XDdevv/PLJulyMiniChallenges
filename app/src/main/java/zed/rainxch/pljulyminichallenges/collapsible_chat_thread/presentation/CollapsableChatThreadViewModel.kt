package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.model.Comment
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.utils.StringProvider
import java.util.UUID

class CollapsableChatThreadViewModel(
    private val stringProvider: StringProvider,
) : ViewModel() {
    private val _state = MutableStateFlow(CollapsableChatThreadUiState())
    val state = _state.asStateFlow()

    init {
        initializeComments()
    }

    private fun initializeComments() {
        val commentsList = listOf<Comment>(
            Comment(
                id = UUID.randomUUID().toString(),
                username = stringProvider(R.string.comment1_username),
                time = stringProvider(R.string.comment1_time),
                badge = stringProvider(R.string.comment1_badge),
                title = stringProvider(R.string.main_post_title),
                body = stringProvider(R.string.comment1_body),
                replies = listOf(
                    Comment(
                        id = UUID.randomUUID().toString(),
                        username = stringProvider(R.string.comment2_username),
                        time = stringProvider(R.string.comment2_time),
                        badge = stringProvider(R.string.comment2_badge),
                        body = stringProvider(R.string.comment2_body)
                    ),
                    Comment(
                        id = UUID.randomUUID().toString(),
                        username = stringProvider(R.string.comment2_username),
                        time = stringProvider(R.string.comment2_time),
                        badge = stringProvider(R.string.comment2_badge),
                        body = stringProvider(R.string.comment2_body)
                    ),
                    Comment(
                        id = UUID.randomUUID().toString(),
                        username = stringProvider(R.string.comment2_username),
                        time = stringProvider(R.string.comment2_time),
                        badge = stringProvider(R.string.comment2_badge),
                        body = stringProvider(R.string.comment2_body)
                    )
                )
            )
        )
    }

    fun onAction(action: CollapsableChatThreadActions) {
        when (action) {
            is CollapsableChatThreadActions.ToggleReplies -> {
                val mutableExpandedCommentIds = _state.value.expandedCommentIds.toMutableList()
                if (action.id in mutableExpandedCommentIds) {
                    mutableExpandedCommentIds.remove(action.id)
                } else {
                    mutableExpandedCommentIds.add(action.id)
                }
                _state.update {
                    it.copy(expandedCommentIds = mutableExpandedCommentIds)
                }
            }
        }
    }
}