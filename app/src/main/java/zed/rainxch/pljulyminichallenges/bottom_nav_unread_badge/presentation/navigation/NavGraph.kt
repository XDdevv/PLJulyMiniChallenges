package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavGraph(
    val route: String,
) {
    @Serializable
    data object ChatsScreen : NavGraph("ChatsScreen")

    @Serializable
    data object CallsScreen : NavGraph("CallsScreen")

    @Serializable
    data object SettingsScreen : NavGraph("SettingsScreen")
}