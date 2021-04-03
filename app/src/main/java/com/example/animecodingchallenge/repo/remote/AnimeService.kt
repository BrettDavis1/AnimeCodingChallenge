package com.example.animecodingchallenge.repo.remote

import com.example.animecodingchallenge.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {
    @GET("anime")
    suspend fun getAnimeByCharacter(@Query("q") character: String) : AnimeResponse
}