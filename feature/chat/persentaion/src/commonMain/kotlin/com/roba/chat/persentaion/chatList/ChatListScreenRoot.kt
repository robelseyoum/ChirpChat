package com.roba.chat.persentaion.chatList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ChatListScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: ChatListViewModel = koinViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to chat",
            style = MaterialTheme.typography.titleLarge
        )
    }

}

@Serializable
object ChatListRoute