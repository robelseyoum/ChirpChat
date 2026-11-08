package com.roba.chat.persentaion.mappers

import com.roba.chat.domain.models.Chat
import com.roba.chat.persentaion.model.ChatUi

fun Chat.toUi(localParticipantId: String): ChatUi {
    val (local, other) = participants.partition { it.userId == localParticipantId }
    return ChatUi(
        id = id,
        localParticipant = local.first().toUi(),
        otherParticipants = other.map { it.toUi() },
        lastMessage = lastMessage,
        lastMessageSenderUsername = participants.find {
            it.userId == lastMessage?.senderId
        }?.userId
    )
}