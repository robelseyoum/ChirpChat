package com.roba.chat.data.chat

import com.roba.chat.data.dto.ChatDto
import com.roba.chat.data.dto.request.CreateChatRequest
import com.roba.chat.data.mappers.toDomain
import com.roba.chat.domain.chat.ChatService
import com.roba.chat.domain.models.Chat
import com.roba.core.data.networking.post
import com.roba.core.domain.util.DataError
import com.roba.core.domain.util.Result
import com.roba.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatService(
    private val httpClient: HttpClient
) : ChatService {

    override suspend fun createChat(otherUserIds: List<String>): Result<Chat, DataError.Remote> {
        return httpClient.post<CreateChatRequest, ChatDto>(
            route = "/chat",
            body = CreateChatRequest(
                otherUserIds = otherUserIds,
            )
        ).map {
            it.toDomain()
        }
    }
}