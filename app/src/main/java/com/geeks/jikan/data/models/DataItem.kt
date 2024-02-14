package com.geeks.jikan.data.models

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("title_japanese")
    val titleJapanese: String = "",
    @SerializedName("favorites")
    val favorites: Int = 0,
    @SerializedName("broadcast")
    val broadcast: Broadcast,
    @SerializedName("year")
    val year: Int? = 0,
    @SerializedName("rating")
    val rating: String = "",
    @SerializedName("scored_by")
    val scoredBy: Int = 0,
    @SerializedName("source")
    val source: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("trailer")
    val trailer: Trailer,
    @SerializedName("duration")
    val duration: String = "",
    @SerializedName("score")
    val score: Double = 0.0,
    @SerializedName("themes")
    val themes: List<ThemesItem>,
    @SerializedName("approved")
    val approved: Boolean = false,
    @SerializedName("genres")
    val genres: List<GenresItem>,
    @SerializedName("popularity")
    val popularity: Int = 0,
    @SerializedName("members")
    val members: Int = 0,
    @SerializedName("title_english")
    val titleEnglish: String = "",
    @SerializedName("rank")
    val rank: Int = 0,
    @SerializedName("season")
    val season: String? = "",
    @SerializedName("airing")
    val airing: Boolean = false,
    @SerializedName("episodes")
    val episodes: Int = 0,
    @SerializedName("aired")
    val aired: Aired,
    @SerializedName("images")
    val images: Images,
    @SerializedName("studios")
    val studios: List<StudiosItem>,
    @SerializedName("mal_id")
    val malId: Int = 0,
    @SerializedName("titles")
    val titles: List<TitlesItem>,
    @SerializedName("synopsis")
    val synopsis: String = "",
    @SerializedName("licensors")
    val licensors: List<LicensorsItem>,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("producers")
    val producers: List<ProducersItem>,
    @SerializedName("background")
    val background: String? = "",
    @SerializedName("status")
    val status: String = ""
)