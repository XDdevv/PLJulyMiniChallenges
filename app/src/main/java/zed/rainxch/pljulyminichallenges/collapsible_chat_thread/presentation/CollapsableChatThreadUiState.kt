package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation

import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.model.Comment

data class CollapsableChatThreadUiState(
    val commentsList: List<Comment> = emptyList(),
    val expandedCommentIds: List<String> = emptyList(),
)
