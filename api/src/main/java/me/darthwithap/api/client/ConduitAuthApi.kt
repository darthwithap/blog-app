package me.darthwithap.api.client

import me.darthwithap.api.models.requests.CreateArticleRequest
import me.darthwithap.api.models.requests.UserUpdateRequest
import me.darthwithap.api.models.responses.ArticleResponse
import me.darthwithap.api.models.responses.ArticlesResponse
import me.darthwithap.api.models.responses.ProfileResponse
import me.darthwithap.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthApi {
    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ): Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @POST("profiles/{username}/follow")
    suspend fun followProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @DELETE("profiles/{username}/follow")
    suspend fun unfollowProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles(): Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleSlug(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @GET("articles/{slug}/favorite")
    suspend fun favoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @DELETE("articles/{slug}/favorite")
    suspend fun unfavoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticleResponse>

    @POST("articles")
    suspend fun createArticle(
        @Body createArticleRequest: CreateArticleRequest
    ): Response<ArticleResponse>
}