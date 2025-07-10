package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.model.BottomNavItem
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.navigation.NavGraph

data class BottomNavUnreadBadgeUiState(
    val bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            hasBadge = false,
            iconRes = R.drawable.ic_chat,
            screen = NavGraph.ChatsScreen
        ),
        BottomNavItem(
            hasBadge = false,
            iconRes = R.drawable.ic_calls,
            screen = NavGraph.CallsScreen
        ),
        BottomNavItem(
            hasBadge = false,
            iconRes = R.drawable.ic_settings,
            screen = NavGraph.SettingsScreen
        )
    ),
)

sealed interface BottomNavUnreadBadgeActions {
    data class OnBottomNavItemSelected(val item: BottomNavItem) : BottomNavUnreadBadgeActions
    data object OnMissCallClick : BottomNavUnreadBadgeActions
    data object OnSendMessageClick : BottomNavUnreadBadgeActions
    data object OnMarkAsReadClick : BottomNavUnreadBadgeActions
}

class BottomNavUnreadBadgeViewModel : ViewModel() {
    private val _state = MutableStateFlow(BottomNavUnreadBadgeUiState())
    val state = _state.asStateFlow()

    fun onAction(action: BottomNavUnreadBadgeActions) {
        when (action) {
            is BottomNavUnreadBadgeActions.OnBottomNavItemSelected -> {
                val selectedItemIndex = _state.value.bottomNavItems.indexOf(action.item)
                val newBottomNavItems = _state.value.bottomNavItems.toMutableList()
                newBottomNavItems[selectedItemIndex] = action.item.copy(hasBadge = false)

                _state.update { it.copy(bottomNavItems = newBottomNavItems) }
            }

            BottomNavUnreadBadgeActions.OnMarkAsReadClick -> {
                val newBottomNavItems = _state.value.bottomNavItems.toMutableList()
                newBottomNavItems.forEachIndexed { index, item ->
                    if (item.screen != NavGraph.SettingsScreen) {
                        newBottomNavItems[index] = item.copy(hasBadge = false)
                    }
                }

                _state.update { it.copy(bottomNavItems = newBottomNavItems) }
            }

            BottomNavUnreadBadgeActions.OnMissCallClick -> {
                val newBottomNavItems = _state.value.bottomNavItems.toMutableList()

                newBottomNavItems[1] = newBottomNavItems[1].copy(hasBadge = true)

                _state.update { it.copy(bottomNavItems = newBottomNavItems) }
            }

            BottomNavUnreadBadgeActions.OnSendMessageClick -> {
                val newBottomNavItems = _state.value.bottomNavItems.toMutableList()

                newBottomNavItems[0] = newBottomNavItems[0].copy(hasBadge = true)

                _state.update { it.copy(bottomNavItems = newBottomNavItems) }

            }
        }
    }
}