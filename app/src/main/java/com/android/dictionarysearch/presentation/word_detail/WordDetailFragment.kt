package com.android.dictionarysearch.presentation.word_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.android.dictionarysearch.R
import com.android.dictionarysearch.databinding.FragmentWordDetailBinding
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.presentation.base.BaseFragment
import com.android.dictionarysearch.presentation.loadImageFull
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordDetailFragment : BaseFragment(), OnWorlDetailCallback {

    private lateinit var fragmentWordDetailBinding: FragmentWordDetailBinding
    private val viewModel: WordDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentWordDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_word_detail, container, false)

        fragmentWordDetailBinding.wordDetailViewModel = viewModel

        val wordMeaning = arguments?.getSerializable(KEY_WORD) as Word
        viewModel.setCurrentWord(wordMeaning)

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)

        return fragmentWordDetailBinding.root

    }

    companion object {

        private const val KEY_WORD = "word"
        val FRAGMENT_NAME = WordDetailFragment::class.java.name

        @JvmStatic
        fun newInstance(word: Word) =
            WordDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_WORD, word)
                }
            }

    }

    override fun bindLiveData() {

        viewModel.wordMeaningData.observe(viewLifecycleOwner, {
            fragmentWordDetailBinding.wordTv.text = it?.translation?.translationText
            fragmentWordDetailBinding.wordPictureIv.loadImageFull(it?.imageUrl)
        })

    }

}