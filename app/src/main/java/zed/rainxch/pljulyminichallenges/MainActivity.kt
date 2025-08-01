package zed.rainxch.pljulyminichallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import zed.rainxch.pljulyminichallenges.bottom_nav_unread_badge.presentation.BottomNavUnreadBadgeScreenRoot
import zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.CollapsableChatThreadScreenRoot
import zed.rainxch.pljulyminichallenges.emoji_composer.presentation.EmojiComposerScreenRoot
import zed.rainxch.pljulyminichallenges.emoji_reaction_bubble.presentation.EmojiReactionBubbleScreenRoot
import zed.rainxch.pljulyminichallenges.message_card.presentation.MessageCardScreenRoot
import zed.rainxch.pljulyminichallenges.ui.theme.PLJulyMiniChallengesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PLJulyMiniChallengesTheme {
                MessageCardScreenRoot()
            }
        }
    }
}