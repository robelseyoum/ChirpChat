package com.roba.chat.persentaion.createChat

import androidx.compose.foundation.text.input.TextFieldState
import com.roba.chat.domain.models.ChatParticipant
import com.roba.core.designsystem.components.avatar.ChatParticipantUi
import com.roba.core.presentation.util.UiText

data class CreateChatState(
    val queryTextState: TextFieldState = TextFieldState(),
    val selectedChatParticipants: List<ChatParticipantUi> = emptyList(),
    val isSearching: Boolean = false,
    val canAddParticipant: Boolean = false,
    val currentSearchResult: ChatParticipantUi? = null,
    val searchError: UiText? = null,
    val isCreatingChat: Boolean = false,
    val createChatError: UiText? = null,
)