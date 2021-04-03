package com.example.animecodingchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.animecodingchallenge.repo.AnimeRepo

class AnimeInfoFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val animes  = AnimeRepo.getFavoriteAnimes(application.applicationContext).asLiveData(viewModelScope.coroutineContext)

}