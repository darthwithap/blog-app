package me.darthwithap.blogapp.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.darthwithap.api.models.entities.Article
import me.darthwithap.blogapp.data.ArticlesRepo

class FeedViewModel : ViewModel() {
    private var _feed: MutableLiveData<List<Article>> = MutableLiveData()
    val feed: LiveData<List<Article>> = _feed

    fun updateGlobalFeed(): Job {
        return viewModelScope.launch {
            ArticlesRepo.getGlobalArticles().body()?.let {
                _feed.postValue(it.articles)
            }
        }
    }
}