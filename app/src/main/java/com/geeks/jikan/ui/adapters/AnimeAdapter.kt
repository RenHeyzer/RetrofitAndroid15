package com.geeks.jikan.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.jikan.data.models.DataItem
import com.geeks.retrofitandroid15.databinding.ItemAnimeBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private val animeList = mutableListOf<DataItem>()

    fun updateAnimeList(animeList: List<DataItem>) {
        this.animeList.addAll(animeList)
        this.animeList.distinctBy {
            it.malId
        }
        notifyDataSetChanged()
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DataItem) = with(binding) {
            Glide.with(ivCover.context)
                .load(item.images.jpg.imageUrl)
                .into(ivCover)

            tvTitle.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(animeList[position])
    }

    override fun getItemCount(): Int = animeList.size
}