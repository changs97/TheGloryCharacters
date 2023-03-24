package com.changs.theglorycharacters.binding

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.changs.theglorycharacters.ui.adapter.CharacterAdapter
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.ui.custom.CharacterView


@BindingAdapter("items")
fun ViewPager2.setItems(list: List<Character>?) {
    list ?: return

    adapter?.let {
        (it as CharacterAdapter).setCharacterList(list)
    }
}

@BindingAdapter("character")
fun CharacterView.setCharacter(character: Character) {
    characterName.text = character.characterName
    actorName.text = character.actor

    Glide.with(context)
        .load(character.image)
        .fitCenter()
        .into(image)
}





