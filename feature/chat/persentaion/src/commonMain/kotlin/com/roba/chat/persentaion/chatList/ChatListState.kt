package com.roba.chat.persentaion.chatList

import com.roba.chat.persentaion.model.ChatUi
import com.roba.core.designsystem.components.avatar.ChatParticipantUi
import com.roba.core.presentation.util.UiText

data class ChatListState(
    val chats: List<ChatUi> = emptyList(),
    val error: UiText? = null,
    val localParticipant: ChatParticipantUi? = null,
    val isUserMenuOpen: Boolean = false,
    val showLogoutConfirmation: Boolean = false,
    val selectedChatId: String? = null,
    val isLoading: Boolean = false,
)