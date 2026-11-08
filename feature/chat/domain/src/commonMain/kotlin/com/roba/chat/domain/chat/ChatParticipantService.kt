package com.roba.chat.domain.chat

import com.roba.chat.domain.models.ChatParticipant
import com.roba.core.domain.util.DataError
import com.roba.core.domain.util.Result

interface ChatParticipantService {
    suspend fun searchParticipant(
        query: String
    ): Result<ChatParticipant, DataError.Remote>
}