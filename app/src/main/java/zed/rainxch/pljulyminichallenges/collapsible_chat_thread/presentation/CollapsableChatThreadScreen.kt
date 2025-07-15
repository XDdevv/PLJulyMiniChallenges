package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.pljulyminichallenges.ui.theme.CollapsableChatThreadColors

@Composable
fun CollapsableChatThreadScreenRoot() {
    val viewModel = viewModel<CollapsableChatThreadViewModel>()
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
                vertical = 32.dp,
                horizontal = 20.dp
            )
    ) {
        
    }
}