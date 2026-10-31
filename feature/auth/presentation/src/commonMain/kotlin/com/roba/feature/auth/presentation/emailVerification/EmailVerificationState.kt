package com.roba.feature.auth.presentation.emailVerification

data class EmailVerificationState(
    val isVerifying: Boolean = false,
    val isVerified: Boolean = false,
)