package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.model.BottomNavItem
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.navigation.NavGraph
import zed.rainxch.pljulyminichallenges.ui.theme.BottomNavigationUnreadBadgeColors

@Composable
fun BottomNavUnreadBadgeBottomNav(
    bottomNavItems: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    var currentScreenIndex by remember { mutableIntStateOf(0) }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    LaunchedEffect(currentRoute) {
        val selectedScreenIndex = bottomNavItems.indexOfFirst {
            currentRoute?.endsWith(it.screen.route, true) == true
        }
        currentScreenIndex = selectedScreenIndex
    }

    Row(
        modifier = modifier
            .wrapContentWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(BottomNavigationUnreadBadgeColors.surface30)
            .border(1.dp, BottomNavigationUnreadBadgeColors.surface50, RoundedCornerShape(18.dp))
            .padding(vertical = 8.dp),
    ) {
        bottomNavItems.forEachIndexed { index, item ->
            BottomNavUnreadBadgeBottomNavItem(
                bottomNavItem = item,
                selected = index == currentScreenIndex,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(horizontal = 12.dp),
                onClick = {
                    navController.navigate(item.screen)
                    onItemClick(item)
                }
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavUnreadBadgeBottomNavPreview() {
    val context = LocalContext.current
    BottomNavUnreadBadgeBottomNav(
        bottomNavItems = listOf(
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
        navController = NavController(context),
        {}
    )
}