package me.darthwithap.blogapp.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.darthwithap.api.ApiClient
import me.darthwithap.api.client.ConduitAuthApi
import me.darthwithap.api.models.entities.Article

class ArticleViewModel : ViewModel() {

    private val authApi: ConduitAuthApi? = ApiClient.authApi

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> = _article

    fun getArticle(slug: String): Job {
        return viewModelScope.launch {
            val response = authApi?.getArticleSlug(slug)
            _article.postValue(response?.body()?.article)
        }
    }
}