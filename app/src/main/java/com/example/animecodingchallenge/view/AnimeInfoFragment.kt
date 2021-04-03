package com.example.animecodingchallenge.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.animecodingchallenge.R
import com.example.animecodingchallenge.databinding.FragmentAnimeInfoBinding
import com.squareup.picasso.Picasso

class AnimeInfoFragment : Fragment() {
    private lateinit var binding: FragmentAnimeInfoBinding
    private val argument by navArgs<AnimeInfoFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentAnimeInfoBinding.inflate(
        inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            tvTitle.text = "Title: ${argument.selectedAnime.title}"
            tvEndDate.text = "End Date: ${argument.selectedAnime.endDate}"
            tvStartDate.text = "Start Date: ${argument.selectedAnime.startDate}"
            tvScore.text = "Score: ${argument.selectedAnime.score.toString()}"
            tvType.text = "Type: ${argument.selectedAnime.type}"
            tvSynopsis.text = "Synopsis: ${argument.selectedAnime.synopsis}"
            Picasso.get().load(argument.selectedAnime.imageUrl).into(ivAnime)
        }
    }

}