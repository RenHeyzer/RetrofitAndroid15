package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class Webp(@SerializedName("large_image_url")
                val largeImageUrl: String = "",
                @SerializedName("small_image_url")
                val smallImageUrl: String = "",
                @SerializedName("image_url")
                val imageUrl: String = "")