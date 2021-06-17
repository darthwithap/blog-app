package me.darthwithap.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.darthwithap.api.models.entities.CommentReq

@JsonClass(generateAdapter = true)
data class CommentRequest(
    @Json(name = "comment")
    val comment: CommentReq
)