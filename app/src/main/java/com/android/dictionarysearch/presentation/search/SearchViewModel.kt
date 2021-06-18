package com.android.dictionarysearch.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.usecase.GetWordsUseCase
import com.android.dictionarysearch.util.LDEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * To store & manage UI-related data in a lifecycle conscious way.
 * This class allows data to survive configuration changes such as screen rotation
 * by interacting with [GetWordsUseCase]
 */
@HiltViewModel
class SearchViewModel @Inject constructor(private val getWordListUseCase: GetWordsUseCase) :
    ViewModel() {

    private val _wordsList = MutableLiveData<LDEvent<List<Word>>>()
    val wordsList: LiveData<LDEvent<List<Word>>> = _wordsList

    private val _isLoading = MutableLiveData<LDEvent<Boolean>>()
    val isLoading: LiveData<LDEvent<Boolean>> = _isLoading

    var previousQueryText = ""

    private val searchSubject: PublishSubject<String> = PublishSubject.create()

    init {
        loadWords()
    }

    private fun loadWords() {

        getWordListUseCase.execute(
            onSuccess = {
                _isLoading.value = LDEvent(false)
                _wordsList.value = LDEvent(it)
            },
            onError = {
                _isLoading.value = LDEvent(false)
                it.printStackTrace()
            },
            params = GetWordsUseCase.GetWordsParams(
                searchSubject
            )
        )

    }

    fun setSearch(queryText: String) {

        if (previousQueryText != queryText) {

            previousQueryText = queryText
            _wordsList.value = LDEvent(listOf())
            _isLoading.value = LDEvent(true)
            searchSubject.onNext(queryText)

        }

    }

}