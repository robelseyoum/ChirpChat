package com.roba.chat.data.di

import com.roba.chat.data.chat.KtorChatParticipantService
import com.roba.chat.data.chat.KtorChatService
import com.roba.chat.domain.chat.ChatParticipantService
import com.roba.chat.domain.chat.ChatService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val chatDataModule = module {
    singleOf(::KtorChatParticipantService) bind ChatParticipantService::class
    singleOf(::KtorChatService) bind ChatService::class
}