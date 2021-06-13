package me.darthwithap.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.darthwithap.api.models.entities.UserUpdates

@JsonClass(generateAdapter = true)
data class UserUpdateRequest(
    @Json(name = "user")
    val userUpdates: UserUpdates
)