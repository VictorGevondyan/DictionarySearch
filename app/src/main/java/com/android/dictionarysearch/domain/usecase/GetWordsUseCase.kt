package com.android.dictionarysearch.domain.usecase

import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.repository.WordRepository
import com.android.dictionarysearch.domain.usecase.base.ObservableUseCase
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * This class is an implementation of {@link ObservableUseCase} that represents a use case for
 * retrieving a collection of all {@link Word}, defined by search.
 */
class GetWordsUseCase @Inject constructor(private val repository: WordRepository) :
    ObservableUseCase<List<Word>, GetWordsUseCase.GetWordsParams>() {

    override fun buildUseCaseObservable(params: GetWordsParams): Observable<List<Word>> {

        return params.searchSubject.debounce(300, TimeUnit.MILLISECONDS)
            .filter { queryText -> queryText.length > 1 }
            .distinctUntilChanged()
            .switchMap { queryText ->
                repository.getWords(queryText)
                    .subscribeOn(Schedulers.io())
            }

    }

    data class GetWordsParams(
        val searchSubject: PublishSubject<String>
    )

}