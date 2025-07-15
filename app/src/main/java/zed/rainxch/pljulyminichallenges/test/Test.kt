package zed.rainxch.pljulyminichallenges.test

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ThousandSeperator(modifier: Modifier = Modifier) {

}

fun getSeperatorText(
    text: String,
    seperatorChar: Char,
): String {
    val textSize = text.length
    if (textSize < 3) {
        return text
    } else {
        val result = StringBuilder(text)
        for (i in textSize downTo 0 step 3) {
            result.insert(i, seperatorChar)
        }

        return result.toString()
    }
}

enum class SeperatorType(val seperatorChar: Char) {
    DOT('.'),
    COMMA(','),
    SPACE(' ')
}

@Preview
@Composable
private fun ThousandSeperatorPreview() {

    ThousandSeperator()
}