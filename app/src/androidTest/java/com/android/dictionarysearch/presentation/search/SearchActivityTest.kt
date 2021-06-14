package com.android.dictionarysearch.presentation.search

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.android.dictionarysearch.R
import com.android.dictionarysearch.presentation.SearchActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SearchActivityTest {


    @get:Rule
    var activityRule = ActivityTestRule(SearchActivity::class.java)

    @Test
    fun container_IsDisplayed() {
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))
    }

}