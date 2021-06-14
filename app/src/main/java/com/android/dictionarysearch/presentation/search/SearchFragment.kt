package com.android.dictionarysearch.presentation.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.dictionarysearch.R
import com.android.dictionarysearch.databinding.FragmentSearchBinding
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.presentation.OnSearchActivityCallback
import com.android.dictionarysearch.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchFragment : BaseFragment(), OnSearchAdapterListener {

    private lateinit var fragmentSearchBinding: FragmentSearchBinding
    private var searchResultsAdapter: SearchResultsAdapter? = null
    private var searchWordClickCallback: OnSearchActivityCallback? = null

    private val viewModel: SearchViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSearchActivityCallback) {
            searchWordClickCallback = context
        } else
            throw ClassCastException(
                context.toString() + "must implement OnSearchActivityCallback!"
            )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchResultsAdapter = SearchResultsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentSearchBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        fragmentSearchBinding.searchViewModel = viewModel

        fragmentSearchBinding.searchView.setOnQueryTextListener(

            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(textToSubmit: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(queryText: String?): Boolean {
                    queryText?.let {
                        val parsedQuery = queryText.trim { it <= ' ' }
                        if (parsedQuery.length > 1) {
                            viewModel.setSearch(parsedQuery)
                        }
                    }
                    return true
                }

            }

        )

        val searchViewPlate =
            fragmentSearchBinding.searchView.findViewById<View>(androidx.appcompat.R.id.search_plate)

        searchViewPlate.background.colorFilter =
            BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                ContextCompat.getColor(requireContext(), R.color.colorAccent),
                BlendModeCompat.SRC_ATOP
            )

        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return fragmentSearchBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSearchBinding.searchRecyclerView.adapter = searchResultsAdapter
        fragmentSearchBinding.searchRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        fragmentSearchBinding.searchRecyclerView.addItemDecoration(decoration)
    }

    override fun onDetach() {
        super.onDetach()
        searchResultsAdapter = null
        searchWordClickCallback = null
    }

    override fun showWordDetails(word: Word) {
        searchWordClickCallback?.openWordDetail(word)
    }

    override fun bindLiveData() {

        viewModel.isLoading.observe(viewLifecycleOwner, {
            it?.let { isLoading ->
                fragmentSearchBinding.wordsProgressBar.visibility =
                    if (isLoading) View.VISIBLE else View.GONE
            }
        })

        viewModel.wordsReceivedLiveData.observe(viewLifecycleOwner, {
            it?.let {
                searchResultsAdapter?.addData(it)
            }
        })

    }

    companion object {

        val FRAGMENT_NAME = SearchFragment::class.java.name

        @JvmStatic
        fun newInstance() =
            SearchFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

}