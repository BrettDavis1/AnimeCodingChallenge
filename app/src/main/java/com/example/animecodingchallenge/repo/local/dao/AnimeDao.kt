package com.example.animecodingchallenge.repo.local.dao

import androidx.room.*
import com.example.animecodingchallenge.model.Anime
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    @Query("SELECT * FROM favorites")
    fun getAll(): Flow<List<Anime>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setAnime(anime: Anime)

    @Delete
    fun delete(anime: Anime)
}