package com.example.animecodingchallenge.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animecodingchallenge.R
import com.example.animecodingchallenge.adapter.AnimeAdapter
import com.example.animecodingchallenge.adapter.AnimeListener
import com.example.animecodingchallenge.databinding.FragmentAnimesBySearchBinding
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.viewmodel.AnimesBySearchFragmentViewModel

class AnimesBySearchFragment : Fragment() {
    private lateinit var binding: FragmentAnimesBySearchBinding
    private val arguments by navArgs<AnimesBySearchFragmentArgs>()
    private val viewModel by viewModels<AnimesBySearchFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAnimesBySearchBinding.inflate(
        inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listener: AnimeListener = object : AnimeListener {
            override fun itemClicked(anime: Anime) {
                val action = AnimesBySearchFragmentDirections.actionAnimesBySearchToAnimeInfo(anime, arguments.character)
                findNavController().navigate(action)
            }
            override fun favoriteClicked(isFavorite: Boolean, anime: Anime) {
                if (isFavorite) { //already a favorite delete it from table
                    viewModel.deleteAnime(anime)
                } else {
                    viewModel.saveAnime(anime)
                }
            }
        }
        binding.btnFavorites.setOnClickListener {
            val action = AnimesBySearchFragmentDirections.actionAnimesBySearchFragmentToFavoritesFragment()
            findNavController().navigate(action)
        }
        binding.tvCharacter.text = arguments.character
        binding.rvAnimes.layoutManager = LinearLayoutManager(this.context)
        binding.rvAnimes.adapter = arguments.animes.results?.let { AnimeAdapter(it, listener, false) }
    }

}