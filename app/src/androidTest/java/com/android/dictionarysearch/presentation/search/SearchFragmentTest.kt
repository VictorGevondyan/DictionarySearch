package com.android.dictionarysearch.presentation.search

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.dictionarysearch.R
import com.android.dictionarysearch.launchFragmentInHiltContainer
import com.android.dictionarysearch.presentation.search.SearchFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class SearchFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
        launchFragmentInHiltContainer<SearchFragment>()
    }

    @Test
    fun isSearchDisplayed() {
        onView(withId(R.id.search_view)).check(
            matches(
                isDisplayed()
            )
        )
    }

}