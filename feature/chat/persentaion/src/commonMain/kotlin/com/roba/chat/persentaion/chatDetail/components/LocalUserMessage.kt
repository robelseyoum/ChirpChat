package com.roba.chat.persentaion.chatDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.roba.core.designsystem.theme.ChirpTheme
import com.roba.core.presentation.util.UiText
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import chirp.feature.chat.persentaion.generated.resources.Res
import chirp.feature.chat.persentaion.generated.resources.delete_for_everyone
import chirp.feature.chat.persentaion.generated.resources.reload_icon
import chirp.feature.chat.persentaion.generated.resources.retry
import chirp.feature.chat.persentaion.generated.resources.you
import com.roba.chat.domain.models.ChatMessageDeliveryStatus
import com.roba.chat.persentaion.model.MessageUi
import com.roba.core.designsystem.components.chat.ChirpChatBubble
import com.roba.core.designsystem.components.chat.TrianglePosition
import com.roba.core.designsystem.components.dropdown.ChirpDropDownMenu
import com.roba.core.designsystem.components.dropdown.DropDownItem
import com.roba.core.designsystem.theme.extended
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun LocalUserMessage(
    message: MessageUi.LocalUserMessage,
    onMessageLongClick: () -> Unit,
    onDismissMessageMenu: () -> Unit,
    onDeleteClick: () -> Unit,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.End)
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            ChirpChatBubble(
                messageContent = message.content,
                sender = stringResource(Res.string.you),
                formattedDateTime = message.formattedSentTime.asString(),
                trianglePosition = TrianglePosition.RIGHT,
                messageStatus = {
                    MessageStatus(
                        status = message.deliveryStatus
                    )
                },
                onLongClick = {
                    onMessageLongClick()
                }
            )

            ChirpDropDownMenu(
                isOpen = message.isMenuOpen,
                onDismiss = onDismissMessageMenu,
                items = listOf(
                    DropDownItem(
                        title = stringResource(Res.string.delete_for_everyone),
                        icon = Icons.Default.Delete,
                        contentColor = MaterialTheme.colorScheme.extended.destructiveHover,
                        onClick = onDeleteClick
                    ),
                )
            )
        }

        if(message.deliveryStatus == ChatMessageDeliveryStatus.FAILED) {
            IconButton(
                onClick = onRetryClick
            ) {
                Icon(
                    imageVector = vectorResource(Res.drawable.reload_icon),
                    contentDescription = stringResource(Res.string.retry),
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview(name = "Local messages - Light", widthDp = 390)
@Composable
private fun LocalUserMessageLightPreview() {
    LocalUserMessagePreviewContent(darkTheme = false)
}

@Preview(name = "Local messages - Dark", widthDp = 390)
@Composable
private fun LocalUserMessageDarkPreview() {
    LocalUserMessagePreviewContent(darkTheme = true)
}

@Composable
private fun LocalUserMessagePreviewContent(darkTheme: Boolean) {
    ChirpTheme(darkTheme = darkTheme) {
        Surface(color = MaterialTheme.colorScheme.surface) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                listOf(
                    ChatMessageDeliveryStatus.SENT to "See you soon!",
                    ChatMessageDeliveryStatus.SENDING to
                        "I'm on my way. I'll meet you at the café near the station in ten minutes.",
                    ChatMessageDeliveryStatus.FAILED to "Could you send the address again?"
                ).forEach { (status, content) ->
                    LocalUserMessage(
                        message = MessageUi.LocalUserMessage(
                            id = status.name,
                            content = content,
                            deliveryStatus = status,
                            isMenuOpen = false,
                            formattedSentTime = UiText.DynamicString("10:30")
                        ),
                        onMessageLongClick = {},
                        onDismissMessageMenu = {},
                        onDeleteClick = {},
                        onRetryClick = {}
                    )
                }
            }
        }
    }
}
