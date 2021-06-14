package com.android.dictionarysearch.presentation.word_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.usecase.GetWordMeaningUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * A helper class for the UI controller that is responsible for
 * preparing data for [WordDetailFragment]
 * */
@HiltViewModel
class WordDetailViewModel @Inject constructor(
    private val getWordMeaningUseCase: GetWordMeaningUseCase
) : ViewModel() {

    val wordMeaningData = MutableLiveData<Word.Meaning>()
    val isLoad = MutableLiveData<Boolean>()

    var word: Word? = null

    fun setCurrentWord(word: Word) {
        this.word = word
    }

//    init {
//        isLoad.value = false
//    }

//    fun getMeaning(id: Long?) {
//        if (id == null) return
//        // TODO: Convert to param
//        getWordMeaningUseCase.execute(
//            onSuccess = {
//                isLoad.value = true
//                wordMeaningData.value = it
//            },
//            onError = {
//                isLoad.value = true
//                it.printStackTrace()
//            },
//            params = GetWordMeaningUseCase.GetWordMeaningParams(wordMeaning)
//        )
//    }

}