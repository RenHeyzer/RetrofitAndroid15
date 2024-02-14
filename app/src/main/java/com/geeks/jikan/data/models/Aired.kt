package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class Aired(@SerializedName("string")
                 val string: String = "",
                 @SerializedName("prop")
                 val prop: Prop,
                 @SerializedName("from")
                 val from: String = "",
                 @SerializedName("to")
                 val to: String? = "")