package com.changs.theglorycharacters.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.viewmodel.MainViewModel
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.CharacterItemBinding
import com.changs.theglorycharacters.ui.custom.CharacterView

class CharacterAdapter(private val listener: CharacterAdapterListener) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    private val characters = ArrayList<Character>()
    interface CharacterAdapterListener {
        fun onCharacterClicked(view: View, character: Character)
    }
    fun setCharacterList(items: List<Character>) {
        characters.run {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size
}
