package me.darthwithap.blogapp.data

import me.darthwithap.api.ApiClient

object ArticlesRepo {
    private val api = ApiClient.api
    private val authApi = ApiClient.authApi

    suspend fun getGlobalFeed() = api.getArticles().body()
    suspend fun getMyFeed() = authApi.getFeedArticles().body()
}