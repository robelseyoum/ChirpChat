package com.roba.chirp

sealed interface MainEvent {
    data object OnSessionExpired: MainEvent
}