package com.geeks.jikan.data.remote.apiservices

import com.geeks.jikan.data.models.JikanRespone
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT = "anime"

interface AnimeApiService {

    @GET(END_POINT)
    fun searchAnime(
        @Query("q") query: String
    ): Call<JikanRespone>
}