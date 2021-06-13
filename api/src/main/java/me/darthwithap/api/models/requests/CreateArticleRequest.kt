package me.darthwithap.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.darthwithap.api.models.entities.ArticleRequest

@JsonClass(generateAdapter = true)
data class CreateArticleRequest(
    @Json(name = "article")
    val articleRequest: ArticleRequest
)