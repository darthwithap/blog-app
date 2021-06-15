package me.darthwithap.blogapp.data

import me.darthwithap.api.ApiClient
import me.darthwithap.api.models.entities.UserLoginCreds
import me.darthwithap.api.models.entities.UserRegisterCreds
import me.darthwithap.api.models.requests.LoginRequest
import me.darthwithap.api.models.requests.RegisterRequest
import me.darthwithap.api.models.responses.UserResponse

object AuthRepo {
    private val api = ApiClient().api

    suspend fun loginUser(email: String, password: String): UserResponse? {
        val response = api.loginUser(
            LoginRequest(
                UserLoginCreds(
                    email, password
                )
            )
        )

        return response.body()
    }

    suspend fun registerUser(email: String, password: String, username: String): UserResponse? {
        val response = api.registerUser(
            RegisterRequest(
                UserRegisterCreds(
                    email, password, username
                )
            )
        )

        return response.body()
    }
}