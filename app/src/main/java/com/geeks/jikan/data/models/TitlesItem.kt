package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class TitlesItem(@SerializedName("type")
                      val type: String = "",
                      @SerializedName("title")
                      val title: String = "")