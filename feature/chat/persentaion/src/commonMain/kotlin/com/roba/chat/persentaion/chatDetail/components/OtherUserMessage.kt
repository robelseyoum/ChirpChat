package com.roba.chat.persentaion.chatDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.roba.core.designsystem.components.avatar.ChatParticipantUi
import com.roba.core.designsystem.theme.ChirpTheme
import com.roba.core.presentation.util.UiText
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.roba.chat.persentaion.model.MessageUi
import com.roba.chat.persentaion.util.getChatBubbleColorForUser
import com.roba.core.designsystem.components.avatar.ChirpAvatarPhoto
import com.roba.core.designsystem.components.chat.ChirpChatBubble
import com.roba.core.designsystem.components.chat.TrianglePosition


@Composable
fun OtherUserMessage(
    message: MessageUi.OtherUserMessage,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ChirpAvatarPhoto(
            displayText = message.sender.initials,
            imageUrl = message.sender.imageUrl
        )
        ChirpChatBubble(
            messageContent = message.content,
            sender = message.sender.username,
            color = color,
            trianglePosition = TrianglePosition.LEFT,
            formattedDateTime = message.formattedSentTime.asString()
        )
    }
}

@Preview(name = "Received messages - Light", widthDp = 390)
@Composable
private fun OtherUserMessageLightPreview() {
    OtherUserMessagePreviewContent(darkTheme = false)
}

@Preview(name = "Received messages - Dark", widthDp = 390)
@Composable
private fun OtherUserMessageDarkPreview() {
    OtherUserMessagePreviewContent(darkTheme = true)
}

@Composable
private fun OtherUserMessagePreviewContent(darkTheme: Boolean) {
    ChirpTheme(darkTheme = darkTheme) {
        Surface(color = MaterialTheme.colorScheme.surface) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                listOf(
                    "Hey!",
                    "Sounds good! We're at the café near the station. There's a table outside, so come and join us when you arrive."
                ).forEachIndexed { index, content ->
                    OtherUserMessage(
                        message = MessageUi.OtherUserMessage(
                            id = "received-$index",
                            content = content,
                            formattedSentTime = UiText.DynamicString("10:32"),
                            sender = ChatParticipantUi(
                                id = "alex",
                                username = "Alex",
                                initials = "AL"
                            )
                        ),
                        color = getChatBubbleColorForUser("id")
                    )
                }
            }
        }
    }
}
