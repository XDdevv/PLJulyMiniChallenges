package zed.rainxch.pljulyminichallenges.collapsible_chat_thread.presentation.utils

import android.content.Context

class StringProvider(
    private val context: Context,
) {

    operator fun invoke(resId: Int): String {
        return context.getString(resId)
    }
}