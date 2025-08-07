package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.model.Comment
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.utils.StringProvider
import java.util.UUID

@Preview
@Composable
private fun CollapsableChatThreadPreviews1() {
    val context = LocalContext.current
    val stringProvider = StringProvider(context)

    val commentsList = listOf<Comment>(
        Comment(
            id = UUID.randomUUID().toString(),
            username = stringProvider(R.string.main_post_username),
            time = stringProvider(R.string.main_post_subreddit),
            badge = stringProvider(R.string.main_post_category),
            title = stringProvider(R.string.main_post_title),
            body = stringProvider(R.string.main_post_body),
            indent = 0,
            replies = listOf(
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment1_username),
                    time = stringProvider(R.string.comment1_time),
                    badge = stringProvider(R.string.comment1_badge),
                    body = stringProvider(R.string.comment1_body),
                    indent = 1,
                    replies = listOf(
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply1_username),
                            time = stringProvider(R.string.comment1_reply1_time),
                            body = stringProvider(R.string.comment1_reply1_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply2_username),
                            time = stringProvider(R.string.comment1_reply2_time),
                            body = stringProvider(R.string.comment1_reply2_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply3_username),
                            time = stringProvider(R.string.comment1_reply3_time),
                            body = stringProvider(R.string.comment1_reply3_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply4_username),
                            time = stringProvider(R.string.comment1_reply4_time),
                            body = stringProvider(R.string.comment1_reply4_body),
                            indent = 2,
                        ),
                    )
                ),
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment2_username),
                    time = stringProvider(R.string.comment2_time),
                    badge = stringProvider(R.string.comment2_badge),
                    body = stringProvider(R.string.comment2_body),
                    indent = 1,
                ),
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment3_username),
                    time = stringProvider(R.string.comment3_time),
                    body = stringProvider(R.string.comment3_body),
                    indent = 1,
                    replies = listOf(
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment3_reply1_username),
                            time = stringProvider(R.string.comment3_reply1_time),
                            body = stringProvider(R.string.comment3_reply1_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment3_reply2_username),
                            time = stringProvider(R.string.comment3_reply2_time),
                            body = stringProvider(R.string.comment3_reply2_body),
                            indent = 2,
                        ),
                    )
                ),
            )
        )
    )

    CollapsableChatThreadScreen(
        state = CollapsableChatThreadUiState(
            commentsList = commentsList,
            expandedCommentIds = listOf()
        ),
        onAction = {

        }
    )
}@Preview
@Composable
private fun CollapsableChatThreadPreviews2() {
    val context = LocalContext.current
    val stringProvider = StringProvider(context)
    val id1 = UUID.randomUUID().toString()

    val commentsList = listOf<Comment>(
        Comment(
            id = id1,
            username = stringProvider(R.string.main_post_username),
            time = stringProvider(R.string.main_post_subreddit),
            badge = stringProvider(R.string.main_post_category),
            title = stringProvider(R.string.main_post_title),
            body = stringProvider(R.string.main_post_body),
            indent = 0,
            replies = listOf(
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment1_username),
                    time = stringProvider(R.string.comment1_time),
                    badge = stringProvider(R.string.comment1_badge),
                    body = stringProvider(R.string.comment1_body),
                    indent = 1,
                    replies = listOf(
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply1_username),
                            time = stringProvider(R.string.comment1_reply1_time),
                            body = stringProvider(R.string.comment1_reply1_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply2_username),
                            time = stringProvider(R.string.comment1_reply2_time),
                            body = stringProvider(R.string.comment1_reply2_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply3_username),
                            time = stringProvider(R.string.comment1_reply3_time),
                            body = stringProvider(R.string.comment1_reply3_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply4_username),
                            time = stringProvider(R.string.comment1_reply4_time),
                            body = stringProvider(R.string.comment1_reply4_body),
                            indent = 2,
                        ),
                    )
                ),
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment2_username),
                    time = stringProvider(R.string.comment2_time),
                    badge = stringProvider(R.string.comment2_badge),
                    body = stringProvider(R.string.comment2_body),
                    indent = 1,
                ),
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment3_username),
                    time = stringProvider(R.string.comment3_time),
                    body = stringProvider(R.string.comment3_body),
                    indent = 1,
                    replies = listOf(
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment3_reply1_username),
                            time = stringProvider(R.string.comment3_reply1_time),
                            body = stringProvider(R.string.comment3_reply1_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment3_reply2_username),
                            time = stringProvider(R.string.comment3_reply2_time),
                            body = stringProvider(R.string.comment3_reply2_body),
                            indent = 2,
                        ),
                    )
                ),
            )
        )
    )

    CollapsableChatThreadScreen(
        state = CollapsableChatThreadUiState(
            commentsList = commentsList,
            expandedCommentIds = listOf(id1)
        ),
        onAction = {

        }
    )
}

@Preview
@Composable
private fun CollapsableChatThreadPreviews3() {
    val context = LocalContext.current
    val stringProvider = StringProvider(context)
    val id1 = UUID.randomUUID().toString()
    val id2 = UUID.randomUUID().toString()

    val commentsList = listOf<Comment>(
        Comment(
            id = id1,
            username = stringProvider(R.string.main_post_username),
            time = stringProvider(R.string.main_post_subreddit),
            badge = stringProvider(R.string.main_post_category),
            title = stringProvider(R.string.main_post_title),
            body = stringProvider(R.string.main_post_body),
            indent = 0,
            replies = listOf(
                Comment(
                    id = id2,
                    username = stringProvider(R.string.comment1_username),
                    time = stringProvider(R.string.comment1_time),
                    badge = stringProvider(R.string.comment1_badge),
                    body = stringProvider(R.string.comment1_body),
                    indent = 1,
                    replies = listOf(
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply1_username),
                            time = stringProvider(R.string.comment1_reply1_time),
                            body = stringProvider(R.string.comment1_reply1_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply2_username),
                            time = stringProvider(R.string.comment1_reply2_time),
                            body = stringProvider(R.string.comment1_reply2_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply3_username),
                            time = stringProvider(R.string.comment1_reply3_time),
                            body = stringProvider(R.string.comment1_reply3_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment1_reply4_username),
                            time = stringProvider(R.string.comment1_reply4_time),
                            body = stringProvider(R.string.comment1_reply4_body),
                            indent = 2,
                        ),
                    )
                ),
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment2_username),
                    time = stringProvider(R.string.comment2_time),
                    badge = stringProvider(R.string.comment2_badge),
                    body = stringProvider(R.string.comment2_body),
                    indent = 1,
                ),
                Comment(
                    id = UUID.randomUUID().toString(),
                    username = stringProvider(R.string.comment3_username),
                    time = stringProvider(R.string.comment3_time),
                    body = stringProvider(R.string.comment3_body),
                    indent = 1,
                    replies = listOf(
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment3_reply1_username),
                            time = stringProvider(R.string.comment3_reply1_time),
                            body = stringProvider(R.string.comment3_reply1_body),
                            indent = 2,
                        ),
                        Comment(
                            id = UUID.randomUUID().toString(),
                            username = stringProvider(R.string.comment3_reply2_username),
                            time = stringProvider(R.string.comment3_reply2_time),
                            body = stringProvider(R.string.comment3_reply2_body),
                            indent = 2,
                        ),
                    )
                ),
            )
        )
    )

    CollapsableChatThreadScreen(
        state = CollapsableChatThreadUiState(
            commentsList = commentsList,
            expandedCommentIds = listOf(id1, id2)
        ),
        onAction = {

        }
    )
}