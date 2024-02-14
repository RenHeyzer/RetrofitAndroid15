package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class Pagination(@SerializedName("has_next_page")
                      val hasNextPage: Boolean = false,
                      @SerializedName("last_visible_page")
                      val lastVisiblePage: Int = 0,
                      @SerializedName("items")
                      val items: Items,
                      @SerializedName("current_page")
                      val currentPage: Int = 0)