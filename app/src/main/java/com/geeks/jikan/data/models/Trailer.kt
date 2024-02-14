package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class Trailer(@SerializedName("images")
                   val images: Images?,
                   @SerializedName("embed_url")
                   val embedUrl: String?,
                   @SerializedName("youtube_id")
                   val youtubeId: String?,
                   @SerializedName("url")
                   val url: String?)