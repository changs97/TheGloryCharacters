package com.changs.theglorycharacters.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.databinding.CharacterItemBinding
import com.changs.theglorycharacters.data.Character

class CharacterViewHolder(
    private val binding: CharacterItemBinding, onClickListener: (Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.characterItemView.setOnClickListener {
            onClickListener(adapterPosition)
        }
    }

    fun bind(item: Character) {
        binding.item = item
        binding.executePendingBindings()
    }
}