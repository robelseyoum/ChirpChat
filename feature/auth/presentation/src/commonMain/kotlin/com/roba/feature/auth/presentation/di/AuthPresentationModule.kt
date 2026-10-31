package com.roba.feature.auth.presentation.di

import com.roba.feature.auth.presentation.emailVerification.EmailVerificationViewModel
import com.roba.feature.auth.presentation.forgotPassword.ForgotPasswordViewModel
import com.roba.feature.auth.presentation.login.LoginViewModel
import com.roba.feature.auth.presentation.register.RegisterViewModel
import com.roba.feature.auth.presentation.registerSuccess.RegisterSuccessViewModel
import com.roba.feature.auth.presentation.restpassword.ResetPasswordViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ForgotPasswordViewModel)
    viewModelOf(::ResetPasswordViewModel)
}