package com.roba.feature.auth.presentation.registerSuccess

sealed interface RegisterSuccessEvent {
    data object ResendVerificationEmailSuccess: RegisterSuccessEvent
}