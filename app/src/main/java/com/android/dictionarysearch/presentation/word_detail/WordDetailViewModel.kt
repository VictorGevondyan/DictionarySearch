package com.android.dictionarysearch.presentation.word_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dictionarysearch.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * A helper class for the UI controller that is responsible for
 * preparing data for [WordDetailFragment]
 * */
@HiltViewModel
class WordDetailViewModel @Inject constructor() : ViewModel() {

    val wordMeaningData = MutableLiveData<Word.Meaning>()
    val isLoad = MutableLiveData<Boolean>()

    var word: Word? = null

    fun setCurrentWord(word: Word) {
        this.word = word
    }

}