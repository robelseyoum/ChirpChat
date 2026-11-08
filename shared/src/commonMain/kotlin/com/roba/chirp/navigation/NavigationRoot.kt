package com.roba.chirp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.roba.chat.persentaion.navigation.ChatGraphRoutes
import com.roba.chat.persentaion.navigation.chatGraph
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
                navController.navigate(ChatGraphRoutes.Graph) {
                    popUpTo(AuthGraphRoutes.Graph) {
                        inclusive = true
                    }
                }
            }
        )

        chatGraph(
            navController = navController
        )
    }
}