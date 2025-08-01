package zed.rainxch.pljulyminichallenges.message_card.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.ui.theme.MessageCardColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun MessageCardButton(
    text: String,
    icon: ImageVector,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(0.dp),
        border = BorderStroke(
            width = 1.dp,
            color = if (enabled) {
                MessageCardColors.primary
            } else MessageCardColors.onSurfaceVar
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = MessageCardColors.primary,
            disabledContentColor = MessageCardColors.onSurfaceVar
        ),
        enabled = enabled,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(18.dp)
            )

            Text(
                text = text,
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}

@Preview
@Composable
private fun MessageCardButtonEnabledPreview() {
    MessageCardButton(
        text = "Mark as Sent",
        icon = ImageVector.vectorResource(R.drawable.icon_read),
        enabled = true,
        onClick = {}
    )
}

@Preview
@Composable
private fun MessageCardButtonDisabledPreview() {
    MessageCardButton(
        text = "Mark as Sent",
        icon = ImageVector.vectorResource(R.drawable.icon_unread),
        enabled = false,
        onClick = {}
    )
}