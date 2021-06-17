package me.darthwithap.api.client

import me.darthwithap.api.models.requests.LoginRequest
import me.darthwithap.api.models.requests.RegisterRequest
import me.darthwithap.api.models.responses.ArticlesResponse
import me.darthwithap.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {
    @POST("users/login")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): Response<UserResponse>

    @POST("users")
    suspend fun registerUser(
        @Body registerRequest: RegisterRequest
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag: String? = null,
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ArticlesResponse>
}