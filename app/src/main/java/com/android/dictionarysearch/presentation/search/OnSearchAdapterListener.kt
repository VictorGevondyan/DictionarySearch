package com.android.dictionarysearch.presentation.search

import com.android.dictionarysearch.domain.model.Word

/**
 * To make an interaction between [SearchResultsAdapter] & [SearchFragment]
 * */
interface OnSearchAdapterListener {
    fun showWordDetails(word: Word)
}