package com.roba.chat.persentaion.createChat

import com.roba.chat.domain.models.Chat

interface CreateChatEvent {
    data class onChatCreated(val chat: Chat): CreateChatEvent
}