package me.darthwithap.api

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Test

class ApiClientTest {
    private val apiClient = ApiClient()

    @Test
    fun `GET Articles`() {

        runBlocking {
            val articles = apiClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET Articles by Author`() {
        runBlocking {
            val articles = apiClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET Articles by Tags`() {
        runBlocking {
            val articles = apiClient.api.getArticles(tag = "butts")
            assertNotNull(articles.body()?.articles)
        }
    }
}