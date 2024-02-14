package com.geeks.jikan.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geeks.jikan.data.models.DataItem
import com.geeks.jikan.data.repositories.AnimeRepository
import com.geeks.jikan.utils.UiState

class AnimeViewModel : ViewModel() {

    private val animeRepository = AnimeRepository()
    private val _animeLiveData = MutableLiveData<UiState<List<DataItem>>>()
    val animeLiveData: LiveData<UiState<List<DataItem>>> = _animeLiveData

    fun searchAnime(query: String) {
        animeRepository.searchAnime(
            query = query,
            onResponse = { data ->
                _animeLiveData.value = UiState(isLoading = false, success = data)
            },
            onFailure = { message, t ->
                Log.e("searchAnime", message, t)
                _animeLiveData.value = UiState(isLoading = false, errorMessage = message)
            })
    }
}