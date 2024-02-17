package com.geeks.jikan.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.jikan.data.models.DataItem
import com.geeks.jikan.data.repositories.AnimeRepository
import com.geeks.jikan.utils.UiState

class AnimeDetailViewModel : ViewModel() {

    private val animeRepository = AnimeRepository()
    private val _animeDetailLiveData = MutableLiveData<UiState<DataItem>>()
    val animeDetailLiveData: LiveData<UiState<DataItem>> = _animeDetailLiveData

    fun getAnimeFullById(id: Int) {
        animeRepository.getAnimeFullById(
            id = id,
            onResponse = { anime ->
                _animeDetailLiveData.value = UiState(isLoading = false, success = anime)
            },
            onFailure = { message, t ->
                Log.e("getAnimeFullById", message, t)
                _animeDetailLiveData.value = UiState(isLoading = false, errorMessage = message)
            }
        )
    }
}