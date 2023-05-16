package com.changs.theglorycharacters.ui.adapter



import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.databinding.CharacterItemBinding
import com.changs.theglorycharacters.data.Character



class CharacterViewHolder(
    private val binding: CharacterItemBinding, listener: CharacterAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = listener
    }

    fun bind(item: Character) {
        binding.item = item
        binding.executePendingBindings()
    }
}