package com.changs.theglorycharacters.ui.adapter

import android.view.View
import com.changs.theglorycharacters.data.Character

interface CharacterAdapterListener {
    fun onCharacterClicked(view: View, character: Character)
}