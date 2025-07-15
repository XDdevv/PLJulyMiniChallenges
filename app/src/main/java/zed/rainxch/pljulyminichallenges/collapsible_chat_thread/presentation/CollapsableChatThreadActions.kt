package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation

sealed interface CollapsableChatThreadActions {
    data class ToggleReplies(val id: String) : CollapsableChatThreadActions
}