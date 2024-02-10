package com.geeks.retrofitandroid15.data.remote.apiservices

import com.geeks.retrofitandroid15.data.models.Post
import retrofit2.Call
import retrofit2.http.GET

private const val POSTS_END_POINT = "posts"

interface PostsApiService {

    @GET(POSTS_END_POINT)
    fun getPosts(): Call<List<Post>>
}