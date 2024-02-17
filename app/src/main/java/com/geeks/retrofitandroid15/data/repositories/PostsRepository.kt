package com.geeks.retrofitandroid15.data.repositories

import com.geeks.retrofitandroid15.data.models.Post
import com.geeks.retrofitandroid15.data.remote.RetrofitClient
import com.geeks.retrofitandroid15.utils.CustomCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsRepository {

    private val apiService = RetrofitClient.postsApiService

    fun getPosts(callback: CustomCallback<List<Post>>) {
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    callback.onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                callback.onFailure(t)
            }
        })
    }

    fun getPosts(
        onResponse: (posts: List<Post>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    fun createNewPost(
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.createNewPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun updatePost(
        postId: Int,
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        apiService.updatePost(postId = postId, post = post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }
}