package com.geeks.jikan.ui.fragments.anime

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.geeks.jikan.ui.adapters.AnimeAdapter
import com.geeks.jikan.ui.viewmodels.AnimeViewModel
import com.geeks.retrofitandroid15.databinding.FragmentAnimeBinding

class AnimeFragment : Fragment() {

    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        search()
        subscribeToSearchAnime()
    }

    private fun initialize() {
        binding.rvAnime.adapter = animeAdapter
    }

    private fun search() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    viewModel.searchAnime(it.toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun subscribeToSearchAnime() {
        viewModel.animeLiveData.observe(viewLifecycleOwner) { uiState ->
            uiState?.let {
                if (it.success != null) {
                    animeAdapter.updateAnimeList(it.success)
                } else {
                    Toast.makeText(context ?: requireContext(), it.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}