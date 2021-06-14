package com.android.dictionarysearch.data.source.remote

import com.android.dictionarysearch.domain.model.Word
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("words/search")
    fun getWords(@Query("search") search: String): Observable<List<Word>>

}