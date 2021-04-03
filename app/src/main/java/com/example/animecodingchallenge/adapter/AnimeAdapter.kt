package com.example.animecodingchallenge.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.animecodingchallenge.R
import com.example.animecodingchallenge.databinding.AnimeItemBinding
import com.example.animecodingchallenge.model.Anime
import com.squareup.picasso.Picasso
import kotlin.coroutines.coroutineContext

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
                if(isFavList) btnFavorite.text = root.context.getString(R.string.unfavorite)
                tvScore.text = root.context.getString(R.string.tv_score ,anime.score)
                tvTitle.text = root.context.getString(R.string.tv_title ,anime.title)
                tvType.text = root.context.getString(R.string.tv_type ,anime.type)
                // need a way to know if anime is already a favorite
                btnFavorite.setOnClickListener {
                    Log.i("AnimeAdapter", "setAnime: ${btnFavorite.text}")
                    if(btnFavorite.text.toString().equals(root.context.getString(R.string.favorite), true)) {
                        listener.favoriteClicked(false, anime)
                        btnFavorite.text = root.context.getString(R.string.unfavorite)
                    } else {
                        listener.favoriteClicked(true, anime)
                        btnFavorite.text = root.context.getString(R.string.favorite)
                    }
                }
                Picasso.get().load(anime.imageUrl).into(ivAnime)
            }
        }
    }
}