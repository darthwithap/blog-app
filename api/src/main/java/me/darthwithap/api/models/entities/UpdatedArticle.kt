package me.darthwithap.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdatedArticle(
    @Json(name = "body")
    val body: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "title")
    val title: String?
)