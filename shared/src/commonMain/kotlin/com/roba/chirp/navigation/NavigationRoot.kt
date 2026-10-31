package com.roba.chirp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roba.chat.persentaion.chatList.ChatListRoute
import com.roba.chat.persentaion.chatList.ChatListScreenRoot
import com.roba.feature.auth.presentation.navigation.AuthGraphRoutes
import com.roba.feature.auth.presentation.navigation.authGraph


@Composable
fun NavigationRoot(
    navController: NavHostController,
    startDestination: Any
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(
            navController = navController,
            onLoginSuccess = {
                navController.navigate(ChatListRoute) {
                    popUpTo(AuthGraphRoutes.Graph) {
                        inclusive = true
                    }
                }
            }
        )
        //todo for testing
        composable<ChatListRoute> {
            ChatListScreenRoot()
        }
    }
}