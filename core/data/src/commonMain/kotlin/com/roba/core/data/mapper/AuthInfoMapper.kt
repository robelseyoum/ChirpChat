package com.roba.core.data.mapper

import com.roba.core.data.dto.AuthInfoSerializable
import com.roba.core.data.dto.UserSerializable
import com.roba.core.domain.auth.AuthInfo
import com.roba.core.domain.auth.User

fun AuthInfoSerializable.toDomain(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toDomain()
    )
}

fun AuthInfo.toSerializable(): AuthInfoSerializable {
    return AuthInfoSerializable(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toUserSerializable()
    )
}

fun UserSerializable.toDomain(): User {
    return User(
        id = id,
        email = email,
        userName = username,
        hasVerifiedEmail = hasVerifiedEmail,
        profilePictureUrl = profilePictureUrl
    )
}

fun User.toUserSerializable(): UserSerializable {
    return UserSerializable(
        id = id,
        email = email,
        username = userName,
        hasVerifiedEmail = hasVerifiedEmail,
        profilePictureUrl = profilePictureUrl,
    )
}
