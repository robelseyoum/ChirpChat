package com.roba.chat.persentaion.chatDetail.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import com.roba.chat.domain.models.ChatMessageDeliveryStatus
import com.roba.core.designsystem.components.avatar.ChatParticipantUi
import com.roba.core.designsystem.theme.ChirpTheme
import com.roba.core.presentation.util.UiText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import chirp.feature.chat.persentaion.generated.resources.Res
import chirp.feature.chat.persentaion.generated.resources.no_messages
import chirp.feature.chat.persentaion.generated.resources.no_messages_subtitle
import com.roba.chat.persentaion.components.EmptyListSection
import com.roba.chat.persentaion.model.MessageUi
import org.jetbrains.compose.resources.stringResource

@Composable
fun MessageList(
    messages: List<MessageUi>,
    listState: LazyListState,
    onMessageLongClick: (MessageUi.LocalUserMessage) -> Unit,
    onMessageRetryClick: (MessageUi.LocalUserMessage) -> Unit,
    onDismissMessageMenu: () -> Unit,
    onDeleteMessageClick: (MessageUi.LocalUserMessage) -> Unit,
    modifier: Modifier = Modifier
) {
    if (messages.isEmpty()) {
        Box(
            modifier = modifier
                .padding(vertical = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            EmptyListSection(
                title = stringResource(Res.string.no_messages),
                description = stringResource(Res.string.no_messages_subtitle),
            )
        }
    } else {
        LazyColumn(
            modifier = modifier,
            state = listState,
            contentPadding = PaddingValues(16.dp),
            reverseLayout = true,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = messages,
                key = { it.id }
            ) { message ->
                MessageListItemUi(
                    messageUi = message,
                    onMessageLongClick = onMessageLongClick,
                    onDismissMessageMenu = onDismissMessageMenu,
                    onDeleteClick = onDeleteMessageClick,
                    onRetryClick = onMessageRetryClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItem()
                )
            }
        }
    }
}

@Preview(name = "Messages - Light", widthDp = 390, heightDp = 700)
@Composable
private fun MessageListLightPreview() {
    MessageListPreviewContent(darkTheme = false)
}

@Preview(name = "Messages - Dark", widthDp = 390, heightDp = 700)
@Composable
private fun MessageListDarkPreview() {
    MessageListPreviewContent(darkTheme = true)
}

@Preview(name = "Empty messages - Light", widthDp = 390, heightDp = 700)
@Composable
private fun MessageListEmptyLightPreview() {
    MessageListPreviewContent(darkTheme = false, messages = emptyList())
}

@Preview(name = "Empty messages - Dark", widthDp = 390, heightDp = 700)
@Composable
private fun MessageListEmptyDarkPreview() {
    MessageListPreviewContent(darkTheme = true, messages = emptyList())
}

@Composable
private fun MessageListPreviewContent(
    darkTheme: Boolean,
    messages: List<MessageUi> = previewMessages
) {
    ChirpTheme(darkTheme = darkTheme) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
        ) {
            MessageList(
                messages = messages,
                listState = rememberLazyListState(),
                onMessageLongClick = {},
                onMessageRetryClick = {},
                onDismissMessageMenu = {},
                onDeleteMessageClick = {},
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

// Newest first because MessageList uses reverseLayout.
private val previewMessages = listOf(
    MessageUi.LocalUserMessage(
        id = "failed",
        content = "Could you send the address again?",
        deliveryStatus = ChatMessageDeliveryStatus.FAILED,
        isMenuOpen = false,
        formattedSentTime = UiText.DynamicString("10:34")
    ),
    MessageUi.LocalUserMessage(
        id = "sending",
        content = "I'll be there in ten minutes.",
        deliveryStatus = ChatMessageDeliveryStatus.SENDING,
        isMenuOpen = false,
        formattedSentTime = UiText.DynamicString("10:33")
    ),
    MessageUi.OtherUserMessage(
        id = "received",
        content = "Sounds good! We're at the café near the station. There is a table outside.",
        formattedSentTime = UiText.DynamicString("10:32"),
        sender = ChatParticipantUi(
            id = "participant",
            username = "Alex",
            initials = "AL"
        )
    ),
    MessageUi.LocalUserMessage(
        id = "sent",
        content = "Hey Alex, are we still meeting today?",
        deliveryStatus = ChatMessageDeliveryStatus.SENT,
        isMenuOpen = false,
        formattedSentTime = UiText.DynamicString("10:30")
    ),
    MessageUi.DateSeparator(
        id = "today",
        date = UiText.DynamicString("Today")
    )
)
