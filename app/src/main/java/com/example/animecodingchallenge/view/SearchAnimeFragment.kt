package com.example.animecodingchallenge.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.animecodingchallenge.R
import com.example.animecodingchallenge.databinding.FragmentSearchAnimeBinding
import com.example.animecodingchallenge.viewmodel.SearchAnimeFragmentViewModel

class SearchAnimeFragment : Fragment() {
    private lateinit var binding: FragmentSearchAnimeBinding
    private val viewModel by viewModels<SearchAnimeFragmentViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentSearchAnimeBinding.inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSearch.setOnClickListener {
            viewModel.getAnimes(binding.etCharacter.text.toString())
            // Could change what we get from viewmodel to results(animes) to what we get so this would only run if we animes
            // instead of animeResponse
            // this could be bad but idea is wait until we have animeResponse to go to next fragment
            viewModel.animeResponse.observe(this.viewLifecycleOwner, { animeResponse ->
                val action = SearchAnimeFragmentDirections.actionSearchAnimeFragmentToAnimesBySearch(animeResponse, binding.etCharacter.text.toString())
                findNavController().navigate(action)
            })
        }
    }
}