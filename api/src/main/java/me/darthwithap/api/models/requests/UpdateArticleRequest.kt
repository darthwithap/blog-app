package me.darthwithap.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.darthwithap.api.models.entities.UpdatedArticle

@JsonClass(generateAdapter = true)
data class UpdateArticleRequest(
    @Json(name = "article")
    val updatedArticle: UpdatedArticle?
)