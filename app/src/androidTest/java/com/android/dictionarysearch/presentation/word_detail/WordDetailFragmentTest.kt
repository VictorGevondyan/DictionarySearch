package com.android.dictionarysearch.presentation.word_detail

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.android.dictionarysearch.R
import org.hamcrest.CoreMatchers.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WordDetailFragmentTest {

    private val STRING_TO_BE_TYPED = "Espresso"

    fun isTitleDisplayed(){
        onView(allOf(withId(R.id.word_tv), withText(STRING_TO_BE_TYPED))).check(matches(isDisplayed()))
    }

    @Test
    fun isTranslationDisplayed() {
        onView(withId(R.id.word_translation_tv)).check(matches(isDisplayed()))
    }

}