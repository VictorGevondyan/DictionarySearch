package com.android.dictionarysearch.presentation.search

import androidx.lifecycle.MutableLiveData
import com.android.dictionarysearch.domain.model.Word

/**
 * A helper class for the UI controller that is responsible for
 * preparing data for [WordViewModel] as the UI
 * */
class WordViewModel(word: Word) {

    val wordData = MutableLiveData<Word>()

    init {
        wordData.value = word
    }

}