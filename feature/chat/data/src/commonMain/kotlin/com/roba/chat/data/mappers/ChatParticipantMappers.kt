package com.roba.chat.data.mappers

import com.roba.chat.data.dto.ChatParticipantDto
import com.roba.chat.domain.models.ChatParticipant


fun ChatParticipantDto.toDomain(): ChatParticipant {
    return ChatParticipant(
        userId = userId,
        username = username,
        profilePictureUrl = profilePictureUrl
    )
}
