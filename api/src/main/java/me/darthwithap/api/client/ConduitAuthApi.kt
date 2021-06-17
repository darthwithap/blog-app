package me.darthwithap.api.client

import me.darthwithap.api.models.requests.CommentRequest
import me.darthwithap.api.models.requests.CreateArticleRequest
import me.darthwithap.api.models.requests.UpdateArticleRequest
import me.darthwithap.api.models.requests.UserUpdateRequest
import me.darthwithap.api.models.responses.*
import retrofit2.Response
import retrofit2.http.*
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProvider

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
    suspend fun getFeedArticles(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<ArticlesResponse>

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

    @PUT("/api/articles/{slug}")
    suspend fun updateArticle(
        @Path("slug") slug: String,
        @Body updateArticleRequest: UpdateArticleRequest
    ): Response<ArticleResponse>

    @DELETE("articles/{slug}")
    suspend fun deleteArticle(
        @Path("slug") slug: String
    )

    @POST("/api/articles/{slug}/comments")
    suspend fun postComment(
        @Path("slug") slug: String,
        @Body commentRequest: CommentRequest
    ): Response<CommentResponse>

    @GET("/api/articles/{slug}/comments")
    suspend fun getCommentsOnArticle(
        @Path("slug") slug: String
    ): Response<ArticlesResponse>

    @DELETE("/api/articles/{slug}/comments/{id}")
    suspend fun deleteCommentOnArticle(
        @Path("slug") slug: String,
        @Path("id") commentId: String
    )
}