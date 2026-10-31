package com.roba.feature.auth.presentation.forgotPassword

sealed interface ForgotPasswordAction {
    data object OnSubmitClick: ForgotPasswordAction
}