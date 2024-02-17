package com.geeks.retrofitandroid15.ui.activity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.retrofitandroid15.data.models.Post
import com.geeks.retrofitandroid15.data.repositories.PostsRepository
import com.geeks.retrofitandroid15.utils.UiState

class MainViewModel : ViewModel() {

    private val postsRepository = PostsRepository()
    private val _postsLiveData = MutableLiveData<UiState<List<Post>>>()
    val postsLiveData: LiveData<UiState<List<Post>>> = _postsLiveData

    init {
//        postsRepository.getPosts(object : CustomCallback<List<Post>> {
//            override fun onResponse(data: List<Post>) {
//                _postsLiveData.value = UiState(isLoading = false, success = data)
//            }
//
//            override fun onFailure(t: Throwable) {
//                _postsLiveData.value =
//                    UiState(isLoading = false, errorMessage = t.message ?: "Unknown error!")
//            }
//        })

//        postsRepository.getPosts(
//            onResponse = { posts ->
//                _postsLiveData.value = UiState(isLoading = false, success = posts)
//            },
//            onFailure = { t ->
//                _postsLiveData.value =
//                    UiState(isLoading = false, errorMessage = t.message ?: "Unknown error!")
//            }
//        )
    }

    fun createNewPost(
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        postsRepository.createNewPost(
            post = post,
            onResponse = onSuccess,
            onFailure = { message, t ->
                Log.e("createNewPost", message)
                onFailure(message)
            }
        )
    }

    fun updatePost(
        postId: Int,
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ) {
        postsRepository.updatePost(
            postId = postId,
            post = post,
            onResponse = onSuccess,
            onFailure = { message, t ->
                Log.e("createNewPost", message)
                onFailure(message)
            }
        )
    }
}