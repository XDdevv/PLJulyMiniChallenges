package zed.rainxch.pljulyminichallenges.emoji_composer.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import zed.rainxch.pljulyminichallenges.emoji_composer.presentation.components.EmojiBar
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiComposersColors
import zed.rainxch.pljulyminichallenges.ui.theme.EmojiComposersColors.blue

@Composable
fun EmojiComposerScreenRoot() {
    val viewModel = viewModel<EmojiComposerViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    EmojiComposerScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun EmojiComposerScreen(
    state: EmojiComposerUiState,
    onAction: (EmojiComposerActions) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(EmojiComposersColors.background)
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmojiBar(
                emojis = state.emojis,
                onAction = onAction,
                selectedIndex = state.scaledIndex
            )

            OutlinedTextField(
                value = state.input,
                onValueChange = { _ -> },
                label = {
                    Text(text = "Awesome Message")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = blue,
                    focusedTextColor = blue,
                    unfocusedTextColor = blue,
                    focusedBorderColor = blue,
                    unfocusedBorderColor = blue,
                    focusedLabelColor = blue,
                    unfocusedLabelColor = blue
                )
            )
        }
    }
}

@Preview
@Composable
private fun EmojiComposerScreenPreview() {
    EmojiComposerScreen(
        state = EmojiComposerUiState(),
        onAction = {

        }
    )
}