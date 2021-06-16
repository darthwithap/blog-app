package me.darthwithap.blogapp.data

import me.darthwithap.api.ApiClient
import me.darthwithap.api.models.entities.UserUpdates
import me.darthwithap.api.models.requests.UserUpdateRequest
import me.darthwithap.api.models.responses.UserResponse

object UserRepo {
    private val authApi = ApiClient.authApi

    suspend fun updateUser(
        image: String?,
        bio: String?,
        email: String?,
        username: String?,
        password: String?
    ): UserResponse? {
        val response = authApi.updateCurrentUser(
            UserUpdateRequest(
                UserUpdates(
                    image, bio, email, username, password
                )
            )
        )

        return response.body()
    }
}