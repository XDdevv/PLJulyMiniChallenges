package zed.rainxch.pljulyminichallenges.emoji_composer.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import zed.rainxch.pljulyminichallenges.emoji_composer.presentation.EmojiComposerActions
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiComposersColors
import zed.rainxch.pljulyminichallenges.ui.theme.urbanistFontFamily

@Composable
fun EmojiBar(
    modifier: Modifier = Modifier,
    onAction: (EmojiComposerActions) -> Unit,
    emojis: List<String>,
    selectedIndex: Int,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(EmojiComposersColors.surface30)
            .border(1.dp, EmojiComposersColors.surface50, CircleShape)
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = modifier
                .pointerInput(Unit) {
                    var currentIndex = 0
                    detectDragGestures(
                        onDragStart = { offset ->
                            // Wild way of getting item index )
                            val index = (offset.x / 48.dp.toPx()).toInt()
                            if (index in emojis.indices) {
                                onAction(EmojiComposerActions.StartDrag(index))
                            }
                        },
                        onDrag = { change, _ ->
                            currentIndex = (change.position.x / 48.dp.toPx()).toInt()
                            if (currentIndex in emojis.indices) {
                                onAction(EmojiComposerActions.UpdateDrag(currentIndex))
                            }
                        },
                        onDragEnd = {
                            onAction(EmojiComposerActions.EndDrag(emojis[currentIndex]))
                        }
                    )
                },
        ) {

            for (index in emojis.indices) {
                Box (
                    modifier = Modifier.size(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val scale by animateFloatAsState(
                        targetValue = if (index == selectedIndex) 1.5f else 1f,
                        animationSpec = tween(150),
                        label = "scale"
                    )
                    if (index == selectedIndex) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(EmojiComposersColors.surfaceAlt15)
                                .scale(scale)
                        )
                    }

                    Text(
                        text = emojis[index],
                        fontFamily = urbanistFontFamily,
                        fontWeight = FontWeight.W400,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .scale(scale)
                    )
                }
            }
        }
    }

}

@Composable
fun EmojiItem(
    emoji: String,
    isLongPressing: Boolean,
    onLongClick: () -> Unit,
    onStoppedLongClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

}

@Preview
@Composable
private fun EmojiBarPreview() {
//    EmojiBar(
//        emojis = mapOf(
//            "\uD83D\uDE02" to false,
//            "\uD83D\uDE0D" to false,
//            "\uD83D\uDC7B" to false,
//            "\uD83D\uDC96" to false,
//            "\uD83D\uDE2D" to false
//        ),
//        onAction = {},
//    )
}