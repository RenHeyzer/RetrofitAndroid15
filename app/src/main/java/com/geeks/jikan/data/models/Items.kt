package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class Items(@SerializedName("per_page")
                 val perPage: Int = 0,
                 @SerializedName("total")
                 val total: Int = 0,
                 @SerializedName("count")
                 val count: Int = 0)