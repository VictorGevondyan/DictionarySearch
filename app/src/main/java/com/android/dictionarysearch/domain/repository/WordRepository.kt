package com.android.dictionarysearch.domain.repository

import com.android.dictionarysearch.domain.model.Word
import io.reactivex.Observable
import io.reactivex.Single


/**
 * To make an interaction between [WordRepositoryImp] & [GetWordsUseCase]
 */
interface WordRepository {
    fun getWords(searchQuery: String): Observable<List<Word>>
}