package com.android.dictionarysearch.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.usecase.GetWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**To store & manage UI-related data in a lifecycle conscious way!
 * this class allows data to survive configuration changes such as screen rotation
 * by interacting with [GetWordsUseCase]
 *
 * */
@HiltViewModel
class SearchViewModel @Inject constructor(private val getWordListUseCase: GetWordsUseCase) :
    ViewModel() {

    val wordsReceivedLiveData = MutableLiveData<List<Word>>()
    var isLoading = MutableLiveData<Boolean>()
    var previousQueryText = ""

    private val searchSubject: PublishSubject<String> = PublishSubject.create()

    init {
        loadWords()
    }

    private fun loadWords() {

        getWordListUseCase.execute(
            onSuccess = {
                isLoading.value = false
                wordsReceivedLiveData.value = it
            },
            onError = {
                isLoading.value = false
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
            wordsReceivedLiveData.value = listOf()
            isLoading.value = true
            searchSubject.onNext(queryText)
        }

    }

}