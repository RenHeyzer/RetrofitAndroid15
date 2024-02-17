package com.geeks.jikan.data.repositories

import com.geeks.jikan.data.models.DataItem
import com.geeks.jikan.data.models.AnimeResponse
import com.geeks.jikan.data.models.JikanRespone
import com.geeks.jikan.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeRepository {

    private val animeApiService = RetrofitClient.animeApiService

    fun searchAnime(
        query: String,
        onResponse: (anime: List<DataItem>) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit,
    ) {
        animeApiService.searchAnime(query = query).enqueue(object : Callback<JikanRespone> {
            override fun onResponse(call: Call<JikanRespone>, response: Response<JikanRespone>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<JikanRespone>, t: Throwable) {
                onFailure(t.message ?: "Unknown Error!", t)
            }
        })
    }

    fun getAnimeFullById(
        id: Int,
        onResponse: (anime: DataItem) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit,
    ) {
        animeApiService.getAnimeFullById(id).enqueue(object : Callback<AnimeResponse> {
            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!.data)
                }
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                onFailure(t.message ?: "Unknown Error!", t)
            }
        })
    }
}