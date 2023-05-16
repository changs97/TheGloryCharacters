package com.changs.theglorycharacters.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.changs.theglorycharacters.data.Character

class DiffUtilCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }
}