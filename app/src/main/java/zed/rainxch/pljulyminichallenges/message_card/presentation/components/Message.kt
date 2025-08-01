package zed.rainxch.pljulyminichallenges.message_card.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.R
import zed.rainxch.pljulyminichallenges.message_card.presentation.model.MessageStatus
import zed.rainxch.pljulyminichallenges.ui.theme.MessageCardColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily
import kotlin.time.Clock
import kotlin.time.Duration.Companion.days
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(ExperimentalTime::class)
@Composable
fun Message(
    username: String,
    sentDate: Instant,
    message: String,
    messageStatus: MessageStatus,
    modifier: Modifier = Modifier,
    currentTime: Instant = Clock.System.now(),
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(MessageCardColors.surface50)
            .padding(vertical = 12.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = username,
                fontFamily = urbanistFontFamily,
                color = MessageCardColors.onSurface,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
            )

            Text(
                text = sentDate.toDayFormat(currentTime),
                color = MessageCardColors.surfaceAlt30,
                fontFamily = urbanistFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
            )
        }

        Text(
            text = message,
            color = MessageCardColors.onSurface,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = (16.sp * 1.3f)
        )

        when (messageStatus) {
            MessageStatus.SENT -> {
                MessageStatus(
                    icon = ImageVector.vectorResource(R.drawable.icon_unread),
                    text = messageStatus.text
                )
            }

            MessageStatus.DELIVERED -> {
                MessageStatus(
                    icon = ImageVector.vectorResource(R.drawable.icon_read),
                    text = messageStatus.text
                )
            }

            MessageStatus.READ -> {
                MessageStatus(
                    icon = ImageVector.vectorResource(R.drawable.icon_read),
                    text = messageStatus.text,
                    contentColor = MessageCardColors.blue
                )
            }
        }
    }
}

@Composable
private fun MessageStatus(
    icon: ImageVector,
    text: String,
    contentColor: Color = MessageCardColors.onSurfaceVar,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = contentColor,
            modifier = Modifier.size(16.dp)
        )

        Text(
            text = text,
            color = contentColor,
            fontFamily = urbanistFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 11.sp
        )
    }
}

@OptIn(ExperimentalTime::class)
private fun Instant.toDayFormat(currentTime: Instant): String {
    val missingDays = currentTime.minus(this).inWholeDays
    return "$missingDays day ago"
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun MessagePreviewSent() {
    Message(
        username = "DreamSyntaxHiker",
        sentDate = Clock.System.now().minus(1.days),
        message = "Iʼll send the draft tonight.I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming. ",
        messageStatus = MessageStatus.SENT
    )
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun MessagePreviewDelivered() {
    Message(
        username = "DreamSyntaxHiker",
        sentDate = Clock.System.now().minus(1.days),
        message = "Iʼll send the draft tonight.I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming. ",
        messageStatus = MessageStatus.DELIVERED
    )
}

@OptIn(ExperimentalTime::class)
@Preview
@Composable
private fun MessagePreviewRead() {
    Message(
        username = "DreamSyntaxHiker",
        sentDate = Clock.System.now().minus(1.days),
        message = "Iʼll send the draft tonight.I spent 9 months building what I thought would be a simple app to help people learn new languages through short conversations. I poured my evenings and weekends into it, but the launch was... underwhelming. ",
        messageStatus = MessageStatus.READ
    )
}