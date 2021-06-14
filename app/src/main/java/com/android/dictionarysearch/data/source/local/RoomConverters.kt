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

    @TypeConverter
    fun convertTranslation(translation: Word.Meaning.Translation?): String? {

        return if (translation == null) {
            null
        } else {
            Gson().toJson(translation)
        }

    }

    @TypeConverter
    fun toTranslation(string: String?): Word.Meaning.Translation? {

        if (string == null) {
            return null
        }

        val gson = Gson()

        val type =
            object : TypeToken<Word.Meaning.Translation?>() {}.type

        return gson.fromJson<Word.Meaning.Translation?>(
            string,
            type
        )

    }

}