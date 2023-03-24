package com.changs.theglorycharacters.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.changs.theglorycharacters.data.source.CharacterRepository
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.data.Characters
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository: CharacterRepository = CharacterRepository()

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>>
        get() = _characters

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch {
            val response = repository.getCharacter()
            response?.let {
                _characters.value = response.characters
            }
        }
    }

}