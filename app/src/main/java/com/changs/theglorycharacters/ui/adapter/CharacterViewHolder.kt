package com.changs.theglorycharacters.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.R
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.CharacterItemBinding

class CharacterViewHolder(
    parent: ViewGroup, listener: CharacterAdapterListener
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
) {
    private val binding = CharacterItemBinding.bind(itemView)

    init {
        binding.listener = listener
    }

    fun bind(item: Character) {
        binding.item = item
        binding.executePendingBindings()
    }
}