package com.example.animecodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.repo.AnimeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val favoriteAnimes = AnimeRepo.getFavoriteAnimes(application.applicationContext).asLiveData(viewModelScope.coroutineContext)

    fun deleteAnime(anime: Anime) {
        viewModelScope.launch(Dispatchers.IO) {
            AnimeRepo.deleteAnime(getApplication(), anime)
        }
    }
}