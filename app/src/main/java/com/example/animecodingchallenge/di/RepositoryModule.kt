package com.example.animecodingchallenge.di

import com.example.animecodingchallenge.repo.AnimeRepoHilt
import com.example.animecodingchallenge.repo.remote.AnimeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

//@Module
//@InstallIn(ViewModelComponent::class)
//object RepositoryModule {
//
//    @Provides
//    @ViewModelScoped
//    fun providesRepo() : AnimeService {
//        return AnimeService
//    }
//}