package com.roba.chat.persentaion.di

import com.roba.chat.persentaion.chatList.ChatListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val chatPresentationModule = module {
    viewModelOf(::ChatListViewModel)
}