package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.BottomNavUnreadBadgeActions
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.components.BottomNavUnreadBadgeButton
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.components.BottomNavUnreadBadgeOutlinedButton
import zed.rainxch.pljulyminichallenges.ui.theme.BottomNavigationUnreadBadgeColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun SettingsScreen(
    onAction: (BottomNavUnreadBadgeActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Settings",
            fontSize = 26.sp,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = BottomNavigationUnreadBadgeColors.onSurface
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BottomNavUnreadBadgeButton(
                text = "Miss a Call",
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_calls),
                        contentDescription = "Phone"
                    )
                },
                onClick = {
                    onAction(BottomNavUnreadBadgeActions.OnMissCallClick)
                },
                modifier = Modifier.width(240.dp)
            )
            BottomNavUnreadBadgeButton(
                text = "Send Message",
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_chat),
                        contentDescription = "Message"
                    )
                },
                onClick = {
                    onAction(BottomNavUnreadBadgeActions.OnSendMessageClick)
                },
                modifier = Modifier.width(240.dp)
            )
            BottomNavUnreadBadgeOutlinedButton(
                text = "Mark as Read",
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_done),
                        contentDescription = "Mark as read"
                    )
                },
                onClick = {
                    onAction(BottomNavUnreadBadgeActions.OnMarkAsReadClick)
                },
                modifier = Modifier.width(240.dp)
            )
        }
    }
}

@Composable
@Preview
fun SettingsScreenPreview() {
    SettingsScreen(
        onAction = {  }
    )
}