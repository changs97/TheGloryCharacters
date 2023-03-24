package com.changs.theglorycharacters.data.source


import android.content.Context
import com.changs.theglorycharacters.Application
import com.changs.theglorycharacters.data.Characters
import com.changs.theglorycharacters.data.source.local.JsonParser
import com.google.gson.Gson
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class CharacterRepository {
    private val jsonParser = JsonParser()

    suspend fun getCharacter(): Characters? = jsonParser.parser()
}