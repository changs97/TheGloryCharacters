package com.changs.theglorycharacters.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.CharacterItemBinding

class CharacterAdapter(private val listener: CharacterAdapterListener) :
    ListAdapter<Character, CharacterViewHolder>(DiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}


