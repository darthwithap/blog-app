package me.darthwithap.blogapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.darthwithap.api.models.entities.User
import me.darthwithap.blogapp.data.AuthRepo
import me.darthwithap.blogapp.data.UserRepo

class AuthViewModel : ViewModel() {
    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun login(
        email: String,
        password: String
    ): Job {
        return viewModelScope.launch {
            AuthRepo.loginUser(email, password)?.let {
                _user.postValue(it.user)
            }
        }
    }

    fun register(
        username: String,
        email: String,
        password: String
    ): Job {
        return viewModelScope.launch {
            AuthRepo.registerUser(email, password, username)?.let {
                _user.postValue(it.user)
            }
        }
    }

    fun update(
        image: String?,
        bio: String?,
        username: String?,
        email: String?,
        password: String?
    ): Job {
        return viewModelScope.launch {
            UserRepo.updateUser(image, bio, email, username, password)?.let {
                _user.postValue(it.user)
            }
        }
    }
}