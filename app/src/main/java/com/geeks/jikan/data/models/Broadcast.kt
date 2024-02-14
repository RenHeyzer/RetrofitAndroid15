package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class Broadcast(@SerializedName("string")
                     val string: String? = "",
                     @SerializedName("timezone")
                     val timezone: String? = "",
                     @SerializedName("time")
                     val time: String? = "",
                     @SerializedName("day")
                     val day: String? = "")