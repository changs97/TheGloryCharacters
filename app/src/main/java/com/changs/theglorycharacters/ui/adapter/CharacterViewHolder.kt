package com.changs.theglorycharacters.ui.adapter


import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.databinding.CharacterItemBinding
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.ui.fragment.HomeFragmentDirections


class CharacterViewHolder(
    private val binding: CharacterItemBinding, listener: CharacterAdapter.CharacterAdapterListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        //binding.listener = listener
    }

    fun bind(item: Character) {

        binding.characterItemView.setOnClickListener {

            val directions = HomeFragmentDirections.actionHomeFragmentToDetailFragment(item)
            val extras = FragmentNavigatorExtras(it to item.characterName)

            itemView.findNavController().navigate(
                directions,
                extras
            )
        }
        binding.characterItemView.transitionName = item.characterName
        binding.item = item
        binding.executePendingBindings()
    }
}