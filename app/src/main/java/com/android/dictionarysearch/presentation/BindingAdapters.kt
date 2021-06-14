package com.android.dictionarysearch.presentation

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.android.dictionarysearch.domain.model.Word

@BindingAdapter("translation")
fun setTranslation(textView: TextView, word: Word) {
    textView.text = word.meanings[0].translation.translationText
}

