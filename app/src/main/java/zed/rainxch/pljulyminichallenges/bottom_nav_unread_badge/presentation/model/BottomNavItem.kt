package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.navigation.NavGraph

data class BottomNavItem(
    val hasBadge: Boolean = false,
    val iconRes: Int,
    val screen: NavGraph,
)
