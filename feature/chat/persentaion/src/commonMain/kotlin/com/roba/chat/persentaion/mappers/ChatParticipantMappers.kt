package com.roba.chat.persentaion.mappers

import com.roba.chat.domain.models.ChatParticipant
import com.roba.core.designsystem.components.avatar.ChatParticipantUi

fun ChatParticipant.toUi(): ChatParticipantUi {
    return ChatParticipantUi(
        id = userId,
        username = username,
        initials = initials,
        imageUrl = profilePictureUrl
    )
}