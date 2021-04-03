package com.example.animecodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.repo.AnimeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimesBySearchFragmentViewModel(application: Application) : AndroidViewModel(application) {

    fun saveAnime(anime: Anime) {
        viewModelScope.launch(Dispatchers.IO) {
            AnimeRepo.saveAnime(getApplication(), anime)
        }
    }

    fun deleteAnime(anime: Anime) {
        viewModelScope.launch(Dispatchers.IO) {
            AnimeRepo.deleteAnime(getApplication(), anime)
        }
    }
}