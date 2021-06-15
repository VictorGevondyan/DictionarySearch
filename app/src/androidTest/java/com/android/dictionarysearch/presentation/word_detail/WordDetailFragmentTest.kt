package com.android.dictionarysearch.presentation.word_detail

import androidx.core.os.bundleOf
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import com.android.dictionarysearch.R
import com.android.dictionarysearch.launchFragmentInHiltContainer
import com.android.dictionarysearch.presentation.word_detail.WordDetailFragment.Companion.KEY_WORD
import com.android.dictionarysearch.util.TestUtil
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class WordDetailFragmentTest {

    private val STRING_TO_BE_TYPED = "Espresso"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun isTitleDisplayed() {
        val fragmentArgs = bundleOf(KEY_WORD to TestUtil.createWord(1))
        val scenario = launchFragmentInHiltContainer<WordDetailFragment>(fragmentArgs)
        onView(withId(R.id.word_tv)).check(matches(isDisplayed()))
    }

    @Test
    fun isTranslationDisplayed() {
        val fragmentArgs = bundleOf(KEY_WORD to TestUtil.createWord(1))
        val scenario = launchFragmentInHiltContainer<WordDetailFragment>(fragmentArgs)
        onView(withId(R.id.word_translation_tv)).check(matches(isDisplayed()))
    }

}