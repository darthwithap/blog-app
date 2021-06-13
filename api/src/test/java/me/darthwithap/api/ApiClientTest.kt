package me.darthwithap.api

import kotlinx.coroutines.runBlocking
import me.darthwithap.api.models.entities.UserLoginCreds
import me.darthwithap.api.models.entities.UserRegisterCreds
import me.darthwithap.api.models.requests.LoginRequest
import me.darthwithap.api.models.requests.RegisterRequest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ApiClientTest {
    private val apiClient = ApiClient()

    @Test
    fun `GET articles`() {

        runBlocking {
            val articles = apiClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by Author`() {
        runBlocking {
            val articles = apiClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by Tags`() {
        runBlocking {
            val articles = apiClient.api.getArticles(tag = "butts")
            assertNotNull(articles.body()?.articles)
        }
    }

    //private val rand = Random.nextInt(100, 10000)
    private val rand = 8696

    @Test
    fun `POST users - registerUser`() {
        val userRegisterCreds = UserRegisterCreds(
            "testemail$rand@test.com",
            "pass@$rand",
            "randUser$rand"
        )
        runBlocking {
            val response = apiClient.api.registerUser(RegisterRequest(userRegisterCreds))
            assertEquals(userRegisterCreds.username, response.body()?.user?.username)
        }
    }

    @Test
    fun `POST users - loginUser`() {
        val userLoginCreds = UserLoginCreds(
            "testemail$rand@test.com",
            "pass@$rand"
        )
        runBlocking {
            val response = apiClient.api.loginUser(LoginRequest(userLoginCreds))
            assertEquals(userLoginCreds.email, response.body()?.user?.email)
        }
    }

    @Test
    fun `GET users currentUser`() {
        runBlocking {
            val response =
                apiClient.api.getCurrentUser("Token eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTc1MTA2LCJ1c2VybmFtZSI6InJhbmRVc2VyODY5NiIsImV4cCI6MTYyODY3OTczNn0.O2PwPcvrynYhvyf2xDG7PBKxhIIIyxY6YRarq4Fb0-g")
            assertEquals("randUser8696", response.body()?.user?.username)
        }
    }
}