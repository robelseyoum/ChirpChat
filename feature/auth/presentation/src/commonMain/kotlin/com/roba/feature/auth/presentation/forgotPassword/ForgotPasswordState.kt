package com.roba.feature.auth.presentation.forgotPassword

import androidx.compose.foundation.text.input.TextFieldState
import com.roba.core.presentation.util.UiText

data class ForgotPasswordState(
    val emailTextFieldState: TextFieldState = TextFieldState(),
    val canSubmit: Boolean = false,
    val isLoading: Boolean = false,
    val errorText: UiText? = null,
    val isEmailSentSuccessfully: Boolean = false
)