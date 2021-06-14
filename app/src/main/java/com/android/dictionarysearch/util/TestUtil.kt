package com.android.dictionarysearch.util

import com.android.dictionarysearch.domain.model.Word

object TestUtil {

    fun createWord(id: Long) = Word(
        id = id,
        text = "",
        meanings = arrayListOf(
            Word.Meaning(
                0L,
                Word.Meaning.Translation(
                    "",
                    ""
                ),
                "",
                "",
                ""
            )
        )
    )

    fun makeWordList(size: Int): MutableList<Word> {
        val list = ArrayList<Word>(size)
        list.forEach {
            it.text = "Word ${list.indexOf(it)}"
            it.id = (list.indexOf(it) + 1).toLong()
            list.add(it)
        }
        return list
    }
}