package zed.rainxch.pljulyminichallenges.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

object EmojiReactionBubbleColors {
    val background = Brush.linearGradient(
        listOf(
            Color(0xff06060A),
            Color(0xff0F1318)
        )
    )

    val onSurface = Color(0xffFFFFFF)

    val surface30 = Color(0xff1F222A).copy(alpha = .3f)
    val surface50 = Color(0xff1F222A).copy(alpha = .5f)

    val blue12 = Color(0xff68C3FF).copy(alpha = .12f)

}