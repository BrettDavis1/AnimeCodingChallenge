package com.example.animecodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.repo.AnimeRepo
import com.example.animecodingchallenge.repo.AnimeRepoHilt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesFragmentViewModel @Inject constructor(private val repo: AnimeRepoHilt, application: Application): AndroidViewModel(application) {
    val favoriteAnimes = repo.getFavoriteAnimes(application.applicationContext).asLiveData(viewModelScope.coroutineContext)

    fun deleteAnime(anime: Anime) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteAnime(getApplication(), anime)
        }
    }
}