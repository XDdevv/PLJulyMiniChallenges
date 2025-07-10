package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.LocalActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.calls.CallsScreen
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.chats.ChatsScreen
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.components.BottomNavUnreadBadgeBottomNav
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.navigation.NavGraph
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.settings.SettingsScreen
import zed.rainxch.pljulyminichallenges.ui.theme.BottomNavigationUnreadBadgeColors

@Composable
fun BottomNavUnreadBadgeScreenRoot() {
    val viewModel = viewModel<BottomNavUnreadBadgeViewModel>()
    val state by viewModel.state.collectAsState()

    val activity = LocalActivity.current as ComponentActivity?

    DisposableEffect(Unit) {
        activity?.enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(1)
        )

        onDispose { }
    }

    BottomNavUnreadBadgeScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun BottomNavUnreadBadgeScreen(
    state: BottomNavUnreadBadgeUiState,
    onAction: (BottomNavUnreadBadgeActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BottomNavigationUnreadBadgeColors.background)
            .safeDrawingPadding(),
    ) {
        BottomNavUnreadBadgeBottomNav(
            bottomNavItems = state.bottomNavItems,
            navController = navController,
            modifier = Modifier
                .padding(bottom = 8.dp)
                .align(Alignment.BottomCenter),
            onItemClick = {
                onAction(BottomNavUnreadBadgeActions.OnBottomNavItemSelected(it))
            }
        )

        NavHost(
            navController = navController,
            startDestination = NavGraph.ChatsScreen,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            composable<NavGraph.ChatsScreen>() {
                ChatsScreen()
            }
            composable<NavGraph.CallsScreen>() {
                CallsScreen()
            }
            composable<NavGraph.SettingsScreen>() {
                SettingsScreen(
                    onAction = onAction
                )
            }
        }
    }
}