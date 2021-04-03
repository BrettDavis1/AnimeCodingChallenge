package com.example.animecodingchallenge.adapter

import com.example.animecodingchallenge.model.Anime

interface AnimeListener {
    fun itemClicked(anime: Anime)
    fun favoriteClicked(isFavorite: Boolean, anime: Anime)
}