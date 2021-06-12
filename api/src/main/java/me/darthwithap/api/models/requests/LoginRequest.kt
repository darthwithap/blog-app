package me.darthwithap.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.darthwithap.api.models.entities.UserLoginCreds

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val userCreds: UserLoginCreds
)