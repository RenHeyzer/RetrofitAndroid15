package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class From(@SerializedName("month")
                val month: Int = 0,
                @SerializedName("year")
                val year: Int = 0,
                @SerializedName("day")
                val day: Int = 0)