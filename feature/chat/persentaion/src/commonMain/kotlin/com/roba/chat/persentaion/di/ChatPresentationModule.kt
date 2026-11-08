package com.roba.chat.persentaion.di

import com.roba.chat.persentaion.chatDetail.ChatDetailViewModel
import com.roba.chat.persentaion.chatList.ChatListViewModel
import com.roba.chat.persentaion.chatListDetail.ChatListDetailViewModel
import com.roba.chat.persentaion.createChat.CreateChatViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val chatPresentationModule = module {
    viewModelOf(::ChatListViewModel)
    viewModelOf(::ChatListDetailViewModel)
    viewModelOf(::CreateChatViewModel)
    viewModelOf(::ChatDetailViewModel)
}