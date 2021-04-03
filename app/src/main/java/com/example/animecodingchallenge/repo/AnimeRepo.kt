package com.example.animecodingchallenge.repo

import android.content.Context
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.model.AnimeResponse
import com.example.animecodingchallenge.repo.local.AnimeDatabase
import com.example.animecodingchallenge.repo.remote.RetrofitInstance

object AnimeRepo {
    val animeService = RetrofitInstance.animeService

    suspend fun getAnime(character: String) : AnimeResponse {
        return RetrofitInstance.animeService.getAnimeByCharacter(character)
    }

    fun getFavoriteAnimes(context: Context) = AnimeDatabase.getDatabase(context)
        .animeDao().getAll()

    fun saveAnime(context: Context, anime: Anime) {
        val animeDao = AnimeDatabase.getDatabase(context).animeDao()
        animeDao.setAnime(anime)
    }
    fun deleteAnime(context: Context, anime: Anime) {
        val animeDao = AnimeDatabase.getDatabase(context).animeDao()
        animeDao.delete(anime)
    }
}