package com.changs.theglorycharacters.ui.adapter

import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.R

import com.changs.theglorycharacters.databinding.CharacterItemBinding
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.ui.fragment.HomeFragmentDirections

class CharacterViewHolder(
    private val binding: CharacterItemBinding, listener: CharacterAdapter.CharacterAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.listener = listener
    }

    fun bind(item: Character) {
        binding.item = item
        binding.executePendingBindings()
    }
}