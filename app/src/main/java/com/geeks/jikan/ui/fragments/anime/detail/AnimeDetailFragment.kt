package com.geeks.jikan.ui.fragments.anime.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.geeks.jikan.ui.viewmodels.AnimeDetailViewModel
import com.geeks.retrofitandroid15.databinding.FragmentAnimeDetailBinding

class AnimeDetailFragment : Fragment() {

    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AnimeDetailViewModel>()
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doRequest()
        subscribeToAnimeDetail()
    }

    private fun doRequest() {
        if (args.id != 0) {
            viewModel.getAnimeFullById(args.id)
        }
    }

    private fun subscribeToAnimeDetail() {
        viewModel.animeDetailLiveData.observe(viewLifecycleOwner) { uiState ->
            uiState?.let {
                if (it.success != null) {
                    binding.tvResult.text = it.success.toString()
                } else {
                    Toast.makeText(context ?: requireContext(), it.errorMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}