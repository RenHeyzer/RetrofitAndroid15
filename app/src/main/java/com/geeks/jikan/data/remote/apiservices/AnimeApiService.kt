package com.geeks.jikan.data.remote.apiservices

import com.geeks.jikan.data.models.AnimeResponse
import com.geeks.jikan.data.models.JikanRespone
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val END_POINT = "anime"
private const val GET_FULL_BY_ID_END_POINT = "$END_POINT/{id}/full"

interface AnimeApiService {

    @GET(END_POINT)
    fun searchAnime(
        @Query("q") query: String
    ): Call<JikanRespone>

    @GET(GET_FULL_BY_ID_END_POINT)
    fun getAnimeFullById(
        @Path("id") id: Int
    ): Call<AnimeResponse>
}