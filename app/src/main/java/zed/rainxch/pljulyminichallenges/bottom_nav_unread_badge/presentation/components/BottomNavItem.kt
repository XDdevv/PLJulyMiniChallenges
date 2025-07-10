package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.model.BottomNavItem
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.navigation.NavGraph
import zed.rainxch.pljulyminichallenges.ui.theme.BottomNavigationUnreadBadgeColors

@Composable
fun BottomNavUnreadBadgeBottomNavItem(
    bottomNavItem: BottomNavItem,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (selected) BottomNavigationUnreadBadgeColors.surfaceAlt else
                    Color.Transparent
            )
            .clickable(onClick = onClick),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(bottomNavItem.iconRes),
            contentDescription = bottomNavItem.screen.route,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            tint = if (selected) BottomNavigationUnreadBadgeColors.onSurfaceAlt
            else BottomNavigationUnreadBadgeColors.onSurfaceVar
        )

        if (bottomNavItem.hasBadge) {
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .size(6.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(BottomNavigationUnreadBadgeColors.error)
                    .align(Alignment.TopEnd)
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavUnreadBadgeBottomNavItemPreview() {
    BottomNavUnreadBadgeBottomNavItem(
        bottomNavItem = BottomNavItem(
            hasBadge = true,
            iconRes = R.drawable.ic_done,
            screen = NavGraph.CallsScreen
        ),
        selected = true,
        onClick = {

        }
    )
}