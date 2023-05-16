package com.changs.theglorycharacters.viewmodel

import androidx.lifecycle.*
import com.changs.theglorycharacters.data.Character
import com.changs.theglorycharacters.data.SampleData

class HomeViewModel : ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    var currentItemPosition = 0

    init {
        _characters.value = getCharacter()
    }

    private fun getCharacter() = SampleData.sampleData

}