package me.darthwithap.blogapp.data

import me.darthwithap.api.ApiClient

object ArticlesRepo {
    private val api = ApiClient().api

    suspend fun getGlobalArticles() = api.getArticles().body()
}