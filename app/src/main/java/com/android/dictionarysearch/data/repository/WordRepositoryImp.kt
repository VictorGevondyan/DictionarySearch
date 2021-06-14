package com.android.dictionarysearch.data.repository

import com.android.dictionarysearch.data.source.local.AppDatabase
import com.android.dictionarysearch.data.source.remote.RetrofitService
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.repository.WordRepository
import io.reactivex.Observable

/**
 * This repository is responsible for
 * fetching data [word] from server or db
 * */
class WordRepositoryImp(
    private val database: AppDatabase,
    private val retrofitService: RetrofitService
) : WordRepository {

//    override fun getWordMeaning(wordMeaningId: Long?): Observable<Word.Meaning> {
//        return database.wordDao.getWordDetail(wordMeaningId!!)
//    }

    override fun getWords(searchQuery: String): Observable<List<Word>> {
        return retrofitService.getWords(searchQuery)
    }

}