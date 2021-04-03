package com.example.animecodingchallenge.model


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class AnimeResponse(
    @Json(name = "last_page")
    val lastPage: Int?,
    @Json(name = "request_cache_expiry")
    val requestCacheExpiry: Int?,
    @Json(name = "request_cached")
    val requestCached: Boolean?,
    @Json(name = "request_hash")
    val requestHash: String?,
    @Json(name = "results")
    val results: List<Anime>?
) : Parcelable