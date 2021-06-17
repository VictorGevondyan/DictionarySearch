package com.android.dictionarysearch

import androidx.appcompat.app.AppCompatActivity
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.presentation.OnSearchActivityCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltTestActivity : AppCompatActivity(), OnSearchActivityCallback {
    override fun openWordDetail(word: Word) {}
}