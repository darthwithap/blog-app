package me.darthwithap.api.models.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleRequest(
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "body")
    val body: String,
    @Json(name = "tagList")
    val tagList: List<String>? = null
)