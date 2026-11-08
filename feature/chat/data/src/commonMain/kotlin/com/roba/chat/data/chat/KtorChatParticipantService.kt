package com.roba.chat.data.chat

import com.roba.chat.data.dto.ChatParticipantDto
import com.roba.chat.data.mappers.toDomain
import com.roba.chat.domain.chat.ChatParticipantService
import com.roba.chat.domain.models.ChatParticipant
import com.roba.core.data.networking.get
import com.roba.core.domain.util.DataError
import com.roba.core.domain.util.Result
import com.roba.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatParticipantService(
    private val httpClient: HttpClient
) : ChatParticipantService {

    override suspend fun searchParticipant(query: String): Result<ChatParticipant, DataError.Remote> {
        return httpClient.get<ChatParticipantDto>(
            route = "/participants",
            queryParams = mapOf(
                "query" to query
            )
        ).map { it.toDomain() }
    }
}