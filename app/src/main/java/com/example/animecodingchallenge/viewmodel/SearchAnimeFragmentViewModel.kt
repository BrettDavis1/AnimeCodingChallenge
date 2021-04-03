package com.example.animecodingchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.model.AnimeResponse
import com.example.animecodingchallenge.repo.AnimeRepo
import com.example.animecodingchallenge.repo.AnimeRepoHilt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchAnimeFragmentViewModel @Inject constructor(private val repo: AnimeRepoHilt): ViewModel() {
    private val _animeResponse = MutableLiveData<AnimeResponse>()
    val animeResponse: LiveData<AnimeResponse> get() = _animeResponse

    fun getAnimes(character: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val animeResponse = repo.getAnime(character)
            _animeResponse.postValue(animeResponse)
        }
    }
}
