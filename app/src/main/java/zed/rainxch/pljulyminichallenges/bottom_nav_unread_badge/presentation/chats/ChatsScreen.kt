package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.chats

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.ui.theme.BottomNavigationUnreadBadgeColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun ChatsScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Chats",
            fontSize = 26.sp,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = BottomNavigationUnreadBadgeColors.onSurface
        )
    }
}