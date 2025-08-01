package zed.rainxch.pljulyminichallenges.message_card.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.message_card.presentation.components.AccountIcon
import zed.rainxch.pljulyminichallenges.message_card.presentation.components.Message
import zed.rainxch.pljulyminichallenges.message_card.presentation.components.MessageCardButton
import zed.rainxch.pljulyminichallenges.message_card.presentation.model.MessageStatus
import zed.rainxch.pljulyminichallenges.ui.theme.MessageCardColors
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.ExperimentalTime
import androidx.compose.runtime.getValue

@Composable
fun MessageCardScreenRoot() {
    val viewModel = viewModel<MessageCardViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    MessageCardScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@OptIn(ExperimentalTime::class)
@Composable
fun MessageCardScreen(
    state: MessageCardUiState,
    onAction: (MessageCardActions) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MessageCardColors.background)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center),
            verticalAlignment = Alignment.Bottom
        ) {
            AccountIcon(
                value = 'D',
                bgColor = MessageCardColors.primary,
                textColor = MessageCardColors.onSurfaceAlt
            )

            Message(
                username = "DreamSyntaxHiker",
                sentDate = Clock.System.now().minus(3.days),
                message = "Iʼll send the draft tonight.I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming. ",
                messageStatus = state.selectedStatus
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 86.dp, vertical = 26.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MessageStatus.entries.forEach { status ->
                MessageCardButton(
                    text = "Mark as ${status.text}",
                    icon = ImageVector.vectorResource(
                        id = if (status == MessageStatus.READ) {
                            R.drawable.icon_read
                        } else R.drawable.icon_unread
                    ),
                    enabled = state.selectedStatus != status,
                    onClick = {
                        onAction(MessageCardActions.OnStateSelected(status))
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun MessageCardScreenPreview() {
    MessageCardScreen(
        state = MessageCardUiState(),
        onAction = {

        }
    )
}