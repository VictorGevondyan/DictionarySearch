package com.android.dictionarysearch.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.dictionarysearch.R
import com.android.dictionarysearch.databinding.ActivitySearchBinding
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.presentation.search.SearchFragment
import com.android.dictionarysearch.presentation.word_detail.WordDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), OnSearchActivityCallback {

    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        setSupportActionBar(binding.activityToolbar)
        binding.activityToolbar.setNavigationOnClickListener {
            supportFragmentManager.popBackStack()
        }

        if (savedInstanceState == null) {
            navigateToSearch()
        }

    }

    private fun navigateToSearch() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                SearchFragment.newInstance(),
                SearchFragment.FRAGMENT_NAME
            )
            .commit()
    }

    override fun openWordDetail(word: Word) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                WordDetailFragment.newInstance(word),
                WordDetailFragment.FRAGMENT_NAME
            )
            .addToBackStack(WordDetailFragment.FRAGMENT_NAME)
            .commit()
    }

}
