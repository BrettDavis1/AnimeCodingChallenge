package com.example.animecodingchallenge.repo.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.repo.local.dao.AnimeDao

@Database(entities = [Anime::class], version = 1)
abstract class AnimeDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao

    companion object {
        private var INSTANCE : AnimeDatabase? = null
        private const val DB_NAME = "favorties.db"

        fun getDatabase(context: Context): AnimeDatabase {
            if(INSTANCE == null) {
                synchronized(AnimeDatabase::class.java) {
                    if(INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext, AnimeDatabase::class.java, DB_NAME
                        ).build()
                    }
                }
            }
            return INSTANCE!!
        }
    }

}