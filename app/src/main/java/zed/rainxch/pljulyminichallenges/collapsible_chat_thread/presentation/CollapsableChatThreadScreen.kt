package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation

import android.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.LocalActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.components.CommentItem
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.utils.StringProvider
import zed.rainxch.pljulyminichallenges.ui.theme.CollapsableChatThreadColors

@Composable
fun CollapsableChatThreadScreenRoot() {
    val context = LocalContext.current
    val activity = LocalActivity.current as ComponentActivity

    DisposableEffect(Unit) {
        activity.enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(scrim = Color.TRANSPARENT))
        onDispose { }
    }

    val stringProvider = remember(context) { StringProvider(context) }
    val viewModel = viewModel<CollapsableChatThreadViewModel> {
        CollapsableChatThreadViewModel(
            stringProvider = stringProvider
        )
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    CollapsableChatThreadScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun CollapsableChatThreadScreen(
    state: CollapsableChatThreadUiState,
    onAction: (CollapsableChatThreadActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(CollapsableChatThreadColors.background)
            .safeDrawingPadding()
            .padding(
                vertical = 12.dp,
                horizontal = 20.dp
            )
    ) {
        LazyColumn {
            items(state.commentsList) { comment ->
                CommentItem(
                    comment = comment,
                    expandedCommentIds = state.expandedCommentIds,
                    onShowRepliesClick = { commentId ->
                        onAction(CollapsableChatThreadActions.ToggleReplies(commentId))
                    }
                )
            }
        }
    }
}