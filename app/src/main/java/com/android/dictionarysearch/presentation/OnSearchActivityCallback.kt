package com.android.dictionarysearch.presentation

import com.android.dictionarysearch.domain.model.Word

/**
 * To make an interaction between [SearchActivity] & its children
 * */
interface OnSearchActivityCallback {
    fun openWordDetail(word: Word)
}