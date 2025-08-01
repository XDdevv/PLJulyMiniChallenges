package zed.rainxch.pljulyminichallenges.message_card.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import zed.rainxch.pljulyminichallenges.message_card.presentation.model.MessageStatus

data class MessageCardUiState(
    val selectedStatus: MessageStatus = MessageStatus.SENT
)

sealed interface MessageCardActions {
    data class OnStateSelected(val state: MessageStatus) : MessageCardActions
}

class MessageCardViewModel : ViewModel() {
    private val _state = MutableStateFlow(MessageCardUiState())
    val state = _state.asStateFlow()

    fun onAction(action: MessageCardActions) {
        when (action) {
            is MessageCardActions.OnStateSelected -> {
                _state.update { state ->
                    state.copy(
                        selectedStatus = action.state
                    )
                }
            }
        }
    }
}