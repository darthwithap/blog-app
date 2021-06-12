package me.darthwithap.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.darthwithap.api.models.entities.UserRegisterCreds

@JsonClass(generateAdapter = true)
data class RegisterRequest(
    @Json(name = "user")
    val userCreds: UserRegisterCreds
)