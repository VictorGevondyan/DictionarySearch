package com.android.dictionarysearch.domain.usecase

import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.domain.repository.WordRepository
import com.android.dictionarysearch.domain.usecase.base.ObservableUseCase
import com.android.dictionarysearch.domain.usecase.base.SingleUseCase
import com.android.dictionarysearch.domain.usecase.base.UseCase
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * An interactor that calls the actual implementation of [WordViewModel](which is injected by DI)
 * it handles the response that returns data &
 * contains a list of actions, event steps
 */
class GetWordMeaningUseCase @Inject constructor(private val repository: WordRepository) :
    SingleUseCase<Word.Meaning, GetWordMeaningUseCase.GetWordMeaningParams>() {

    override fun buildUseCaseSingle(params: GetWordMeaningParams): Single<Word.Meaning> {
        return Single.just(params.wordMeaning)
    }

    data class GetWordMeaningParams(
        val wordMeaning: Word.Meaning
    )

}