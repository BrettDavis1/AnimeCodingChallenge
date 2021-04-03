package com.example.animecodingchallenge.repo.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://api.jikan.moe/v3/search/"

    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        .let { logginInterceptor ->
            OkHttpClient.Builder().addInterceptor(logginInterceptor).build()
        }
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    val animeService: AnimeService by lazy {
        retrofit.create(AnimeService::class.java)
    }
}