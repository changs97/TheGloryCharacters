package com.changs.theglorycharacters.data.source.local

import com.changs.theglorycharacters.Application
import com.changs.theglorycharacters.data.Characters
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader

class JsonParser {
    suspend fun parser(): Characters? {
        var characters: Characters? = null

        withContext(Dispatchers.IO) {
            val inputStream =
                Application.getApplicationContext().assets.open("jsons/CharacterList.json")
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)
            val stringBuffer = StringBuffer()
            var line: String?
            try {
                while (bufferedReader.readLine().also { line = it } != null) {
                    stringBuffer.append(line)
                }

                val jsonObject = JSONObject(stringBuffer.toString())
                val gson = Gson()

                characters = gson.fromJson(jsonObject.toString(), Characters::class.java)

            } catch (e: Exception) {
                throw e
            } finally {
                try {
                    inputStream.close()
                    inputStreamReader.close()
                    bufferedReader.close()
                } catch (e: Exception) {
                    throw e
                }
            }
        }
        return characters
    }
}