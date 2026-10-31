package com.roba.chirp.di

import com.roba.chat.persentaion.di.chatPresentationModule
import com.roba.core.data.di.coreDataModule
import com.roba.feature.auth.presentation.di.authPresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule,
            appModule,
            chatPresentationModule
        )
    }
}
