package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class StudiosItem(@SerializedName("name")
                       val name: String = "",
                       @SerializedName("mal_id")
                       val malId: Int = 0,
                       @SerializedName("type")
                       val type: String = "",
                       @SerializedName("url")
                       val url: String = "")