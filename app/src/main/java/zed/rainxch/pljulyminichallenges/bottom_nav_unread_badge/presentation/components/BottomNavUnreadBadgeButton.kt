package zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.ui.theme.BottomNavigationUnreadBadgeColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun BottomNavUnreadBadgeButton(
    text: String,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = BottomNavigationUnreadBadgeColors.primary,
            contentColor = BottomNavigationUnreadBadgeColors.onSurfaceAlt
        ),
        shape = RoundedCornerShape(0.dp),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            icon.invoke()

            Text(
                text = text,
                fontSize = 16.sp,
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavUnreadBadgeButtonPreview() {
    BottomNavUnreadBadgeButton(
        text = "Hello",
        icon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        },
        onClick = {

        }
    )
}