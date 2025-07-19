package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.model.Comment
import zed.rainxch.pljulyminichallenges.ui.theme.CollapsableChatThreadColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun CommentItem(
    comment: Comment,
    expandedCommentIds: List<String>,
    onShowRepliesClick: (commendId: String) -> Unit,
    modifier: Modifier = Modifier,
) {

    val profilePictureColor = remember(comment.id) {
        listOf(
            CollapsableChatThreadColors.primary,
            CollapsableChatThreadColors.yellow,
            CollapsableChatThreadColors.blue,
        ).random()
    }

    var commentHeight by remember { mutableIntStateOf(0) }

    val expanded = remember(expandedCommentIds) { comment.id in expandedCommentIds }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = comment.indent * 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = CollapsableChatThreadColors.surfaceAlt30,
                        shape = CircleShape
                    )
                    .background(profilePictureColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = remember(comment.id) { comment.username.take(1) },
                    color = CollapsableChatThreadColors.onSurfaceAlt,
                    fontSize = 15.sp,
                    fontFamily = urbanistFontFamily,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(

            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = comment.username,
                        color = CollapsableChatThreadColors.onSurface,
                        fontFamily = urbanistFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )

                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(CircleShape)
                            .background(CollapsableChatThreadColors.onSurfaceVar)
                    )

                    Text(
                        text = comment.time,
                        color = CollapsableChatThreadColors.onSurfaceVar,
                        fontFamily = urbanistFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }

                comment.badge?.let { header ->
                    Box(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(bottom = 8.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(profilePictureColor.copy(alpha = .12f))
                            .padding(horizontal = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = header,
                            color = profilePictureColor,
                            fontFamily = urbanistFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 10.sp,
                        )
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        color = Color.White,
                        size = Size(
                            width = 1f,
                            height = if (comment.replies.isNotEmpty()) size.height - 50f
                            else size.height + 150f
                        ),
                    )
                    drawRect(
                        color = Color.White,
                        size = Size(
                            width = 64f,
                            height = 4f
                        ),
                        topLeft = Offset(x = 0f, y = size.height - 50f)
                    )
                }
                .padding(start = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column {
                comment.title?.let { title ->
                    Text(
                        text = title,
                        fontSize = 20.sp,
                        fontFamily = urbanistFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = CollapsableChatThreadColors.onSurface
                    )
                }

                Text(
                    text = comment.body,
                    color = CollapsableChatThreadColors.onSurfaceVar,
                    fontSize = 15.sp,
                    fontFamily = urbanistFontFamily,
                    fontWeight = FontWeight.Normal
                )

                Row(
                    modifier = Modifier.padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    if (comment.replies.isNotEmpty()) {
                        Row(
                            modifier = Modifier.clickable(onClick = {
                                onShowRepliesClick(comment.id)
                            }),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(
                                    id = if (expanded) R.drawable.ic_minus_circle
                                    else R.drawable.ic_plus_circle
                                ),
                                contentDescription = null,
                                tint = CollapsableChatThreadColors.onSurface
                            )

                            Text(
                                text = "${if (expanded) "Hide" else "Show"} ${comment.replies.size} replies",
                                fontFamily = urbanistFontFamily,
                                fontWeight = FontWeight.Medium,
                                color = CollapsableChatThreadColors.onSurface,
                                fontSize = 15.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_reply),
                            contentDescription = null,
                            tint = CollapsableChatThreadColors.onSurface
                        )

                        Text(
                            text = "Reply",
                            fontFamily = urbanistFontFamily,
                            fontWeight = FontWeight.Medium,
                            color = CollapsableChatThreadColors.onSurface,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }

        if (comment.replies.isNotEmpty() && expanded) {
            comment.replies.forEach { comment ->
                CommentItem(
                    comment = comment,
                    expandedCommentIds = expandedCommentIds,
                    onShowRepliesClick = onShowRepliesClick
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xff06060A)
@Composable
private fun CommentItemPreview() {
    CommentItem(
        comment = Comment(
            id = "",
            username = "DreamSyntaxHiker",
            time = "1 day ago",
            badge = "/ProductReflection",
            title = "I Tried to Build a Language-Learning App. It Didn't Go as Planned.",
            body = "I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming.  \n" +
                    "Here's what I learned about feature creep, marketing missteps, and chasing perfection instead of feedback.",
            indent = 0,
            replies = listOf(
                Comment(
                    id = "",
                    username = "DreamSyntaxHiker",
                    time = "1 day ago",
                    badge = "/ProductReflection",
                    body = "I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming.  \n" +
                            "Here's what I learned about feature creep, marketing missteps, and chasing perfection instead of feedback.",
                    indent = 1
                )
            )
        ),
        onShowRepliesClick = {},
        expandedCommentIds = listOf()
    )
}