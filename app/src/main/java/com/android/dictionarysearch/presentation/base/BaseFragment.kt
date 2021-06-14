package com.android.dictionarysearch.presentation.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        // Register LiveData
        bindLiveData()

    }

    protected open fun bindLiveData() {}

}