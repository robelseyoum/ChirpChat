package com.roba.chirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform