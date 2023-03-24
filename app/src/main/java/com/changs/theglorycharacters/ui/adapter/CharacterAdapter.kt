package com.changs.theglorycharacters.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.changs.theglorycharacters.viewmodel.MainViewModel
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.databinding.CharacterItemBinding

class CharacterAdapter(private val viewModel: MainViewModel) :
    RecyclerView.Adapter<CharacterViewHolder>() {
    private val characters = ArrayList<Character>()

    private val onItemClickListener = { position: Int ->
        //viewModel.openMovieLink(movies[position].link)
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
        return CharacterViewHolder(binding, onItemClickListener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size
}
