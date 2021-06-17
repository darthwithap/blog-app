package me.darthwithap.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentReq(
    @Json(name = "body")
    val body: String
)