package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class JikanRespone(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("data")
    val data: List<DataItem>
)