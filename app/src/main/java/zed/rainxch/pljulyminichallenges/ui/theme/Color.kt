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

object BottomNavigationUnreadBadgeColors {
    val background = Brush.linearGradient(
        listOf(
            Color(0xff06060A),
            Color(0xff0F1318)
        )
    )

    val onSurface = Color(0xffFFFFFF)
    val surface30 = Color(0xff1F222A).copy(alpha = .3f)
    val surface50 = Color(0xff1F222A).copy(alpha = .5f)
    val onSurfaceVar = Color(0xff7F8491)
    val surfaceAlt = Color(0xffFFFFFF)
    val surfaceAlt30 = Color(0xffFFFFFF).copy(alpha = .3f)
    val surfaceAlt15 = Color(0xffFFFFFF).copy(alpha = .15f)
    val onSurfaceAlt = Color(0xff0F0F18)
    val error = Color(0xffF83468)
    val primary = Color(0xff75FABF)
}

object CollapsableChatThreadColors {
    val background = Brush.linearGradient(
        listOf(
            Color(0xff06060A),
            Color(0xff0F1318)
        )
    )

    val surface50 = Color(0xff1F222A).copy(alpha = .5f)
    val surfaceAlt30 = Color(0xffffffff).copy(alpha = .3f)

    val onSurface = Color(0xffFFFFFF)
    val onSurfaceVar = Color(0xffAFB2B9)
    val onSurfaceAlt = Color(0xff0F0F18)

    val primary = Color(0xff75FABF)
    val yellow = Color(0xffffc368)
    val blue = Color(0xff68C3FF)

}

fun Long.toColor(): Color {
    return Color(this)
}