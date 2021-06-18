package com.android.dictionarysearch.data.repository

import com.android.dictionarysearch.data.source.remote.RetrofitService
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.repository.WordRepository
import io.reactivex.Observable

/**
 * This repository is responsible for
 * fetching data [word] from server
 * */
class WordRepositoryImp(
    private val retrofitService: RetrofitService
) : WordRepository {

    override fun getWords(searchQuery: String): Observable<List<Word>> {
        return retrofitService.getWords(searchQuery)
    }

}