package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val data: DataItem
)
