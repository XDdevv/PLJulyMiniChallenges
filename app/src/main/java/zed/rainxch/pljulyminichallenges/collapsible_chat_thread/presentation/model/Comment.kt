package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.model

data class Comment(
    val id: String,
    val username: String,
    val time: String,
    val badge: String? = null,
    val title: String? = null,
    val body: String,
    val indent : Int,
    val replies: List<Comment> = emptyList(),
)
