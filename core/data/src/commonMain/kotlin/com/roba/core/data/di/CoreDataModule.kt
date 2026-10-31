package com.roba.core.data.di

import com.roba.core.data.auth.DataStoreSessionStorage
import com.roba.core.data.auth.KtorAuthService
import com.roba.core.data.logging.KermitLogger
import com.roba.core.data.networking.HttpClientFactory
import com.roba.core.domain.auth.AuthService
import com.roba.core.domain.auth.SessionStorage
import com.roba.core.domain.logging.ChirpLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    single<ChirpLogger>{ KermitLogger }
    single {
        HttpClientFactory(get(),get()).create(get())
    }
    singleOf(::KtorAuthService) bind AuthService::class
    singleOf(::DataStoreSessionStorage) bind SessionStorage::class
}
