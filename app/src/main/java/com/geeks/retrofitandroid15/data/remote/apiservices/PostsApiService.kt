package com.geeks.retrofitandroid15.data.remote.apiservices

import com.geeks.retrofitandroid15.data.models.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val POSTS_END_POINT = "posts"

interface PostsApiService {

    @GET(POSTS_END_POINT)
    fun getPosts(): Call<List<Post>>

    @POST(POSTS_END_POINT)
    fun createNewPost(
        @Body post: Post
    ): Call<Post>

    @PUT("$POSTS_END_POINT/{postId}")
    fun updatePost(
        @Path("postId") postId: Int,
        @Body post: Post
    ): Call<Post>
}