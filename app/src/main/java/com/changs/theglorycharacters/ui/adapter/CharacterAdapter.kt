package com.changs.theglorycharacters.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.changs.theglorycharacters.data.Character

class CharacterAdapter(private val listener: CharacterAdapterListener) :
    ListAdapter<Character, CharacterViewHolder>(object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(parent, listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}


