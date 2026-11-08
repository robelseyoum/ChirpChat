package com.roba.chat.domain.chat

import com.roba.chat.domain.models.Chat
import com.roba.core.domain.util.DataError
import com.roba.core.domain.util.Result

interface ChatService {
    suspend fun createChat(
        otherUserIds: List<String>
    ): Result<Chat, DataError.Remote>
}