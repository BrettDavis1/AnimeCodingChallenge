package com.example.animecodingchallenge.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animecodingchallenge.databinding.AnimeItemBinding
import com.example.animecodingchallenge.model.Anime
import com.squareup.picasso.Picasso

class AnimeAdapter(val animes: List<Anime>, private val listener: AnimeListener, val isFavList : Boolean) :
    RecyclerView.Adapter<AnimeAdapter.AnimeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        val binding: AnimeItemBinding = AnimeItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AnimeHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.setAnime(animes[position], listener, isFavList)
    }

    override fun getItemCount(): Int {
        return animes.size
    }
    class AnimeHolder(val binding: AnimeItemBinding, val listener: AnimeListener) : RecyclerView.ViewHolder(binding.root) {
        fun setAnime(anime: Anime, listener: AnimeListener, isFavList: Boolean) {
            binding.apply {
                root.setOnClickListener {
                    listener.itemClicked(anime)
                }
                if(isFavList) btnFavorite.text = "Unfavorite"
                tvScore.text = "Score: ${anime.score.toString()}"
                tvTitle.text = "Title: ${anime.title}"
                tvType.text = "Type: ${anime.type}"
                // need a way to know if anime is already a favorite
                btnFavorite.setOnClickListener {
                    Log.i("AnimeAdapter", "setAnime: ${btnFavorite.text}")
                    if(btnFavorite.text.toString().equals("Favorite", true)) {
                        listener.favoriteClicked(false, anime)
                        btnFavorite.text = "Unfavorite"
                    } else {
                        listener.favoriteClicked(true, anime)
                        btnFavorite.text = "Favorite"
                    }
                }
                Picasso.get().load(anime.imageUrl).into(ivAnime)
            }
        }
    }
}