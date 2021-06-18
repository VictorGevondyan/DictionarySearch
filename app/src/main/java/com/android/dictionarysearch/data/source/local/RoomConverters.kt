package com.android.dictionarysearch.data.source.local

import androidx.room.TypeConverter
import com.android.dictionarysearch.domain.model.Word
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class RoomConverters {

    @TypeConverter
    fun convertMeaningArr(list: ArrayList<Word.Meaning?>?): String? {

        return if (list == null) {
            null
        } else {
            Gson().toJson(list)
        }

    }

    @TypeConverter
    fun toMeaningArr(string: String?): ArrayList<Word.Meaning?>? {

        if (string == null) {
            return null
        }

        val gson = Gson()

        val type =
            object : TypeToken<List<Word.Meaning?>?>() {}.type

        return gson.fromJson<ArrayList<Word.Meaning?>>(
            string,
            type
        )

    }

}