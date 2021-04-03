package com.example.animecodingchallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animecodingchallenge.adapter.AnimeAdapter
import com.example.animecodingchallenge.adapter.AnimeListener
import com.example.animecodingchallenge.databinding.FragmentFavoritesBinding
import com.example.animecodingchallenge.model.Anime
import com.example.animecodingchallenge.viewmodel.FavoritesFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel by viewModels<FavoritesFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentFavoritesBinding.inflate(
        inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFavorites.layoutManager = LinearLayoutManager(this.context)
        val listener: AnimeListener = object : AnimeListener {
            override fun itemClicked(anime: Anime) {
                val action = FavoritesFragmentDirections.actionFavoritesFragmentToAnimeInfoFragment(anime,"Anime from Favorites")
                findNavController().navigate(action)
            }

            override fun favoriteClicked(isFavorite: Boolean, anime: Anime) {
                viewModel.deleteAnime(anime)
            }
        }
        viewModel.favoriteAnimes.observe(this.viewLifecycleOwner, {
            binding.rvFavorites.layoutManager= LinearLayoutManager(this.context)
            binding.rvFavorites.adapter = it?.let{ animes ->
                AnimeAdapter(animes, listener, true)
            }
        })
    }
}