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
    private var _globalFeed: MutableLiveData<List<Article>> = MutableLiveData()
    val globalFeed: LiveData<List<Article>> = _globalFeed
    private var _myFeed: MutableLiveData<List<Article>> = MutableLiveData()
    val myFeed: LiveData<List<Article>> = _myFeed

    fun updateGlobalFeed(): Job {
        return viewModelScope.launch {
            ArticlesRepo.getGlobalFeed()?.let {
                _globalFeed.postValue(it.articles)
            }
        }
    }

    fun updateMyFeed(): Job {
        return viewModelScope.launch {
            ArticlesRepo.getMyFeed().let {
                _myFeed.postValue(it?.articles)
            }
        }
    }
}