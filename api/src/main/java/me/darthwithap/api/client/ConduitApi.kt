package me.darthwithap.api.client

import me.darthwithap.api.models.entities.UserLoginCreds
import me.darthwithap.api.models.entities.UserRegisterCreds
import me.darthwithap.api.models.responses.ArticlesResponse
import me.darthwithap.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ConduitApi {
    @POST("users/login")
    suspend fun loginUser(
        @Body userLoginCreds: UserLoginCreds
    ): Response<UserResponse>

    @POST("users")
    suspend fun registerUser(
        @Body userRegisterCreds: UserRegisterCreds
    ): Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author: String? = null,
        @Query("favorited") favorited: String? = null,
        @Query("tag") tag: String? = null
    ): Response<ArticlesResponse>
}