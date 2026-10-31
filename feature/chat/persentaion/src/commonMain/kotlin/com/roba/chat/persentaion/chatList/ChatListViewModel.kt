package com.roba.chat.persentaion.chatList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roba.core.domain.auth.SessionStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatListViewModel(
    private val sessionStorage: SessionStorage
) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(5000)
            sessionStorage.set(null)
        }
    }
}