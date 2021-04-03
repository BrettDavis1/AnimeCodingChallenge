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
            tvTitle.text = getString(R.string.tv_title, argument.selectedAnime.title)
            tvEndDate.text = getString(R.string.tv_title, argument.selectedAnime.endDate)
            tvStartDate.text = getString(R.string.tv_start_date, argument.selectedAnime.startDate)
            tvScore.text = getString(R.string.tv_score, argument.selectedAnime.score)
            tvType.text = getString(R.string.tv_type, argument.selectedAnime.type)
            tvSynopsis.text = getString(R.string.tv_synopsis, argument.selectedAnime.synopsis)
            Picasso.get().load(argument.selectedAnime.imageUrl).into(ivAnime)
        }
    }

}