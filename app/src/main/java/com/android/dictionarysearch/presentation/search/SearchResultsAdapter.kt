package com.android.dictionarysearch.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.dictionarysearch.R
import com.android.dictionarysearch.databinding.HolderWordBinding
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.presentation.search.SearchResultsAdapter.WordViewHolder
import java.util.*

/**
 * This class is responsible for converting each data entry [Word]
 * into [WordViewHolder] that can then be added to the AdapterView.
 */
class SearchResultsAdapter(val searchWordClickListener: OnSearchAdapterListener) :
    RecyclerView.Adapter<WordViewHolder>() {

    private val words: MutableList<Word> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

        val holderWordBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.holder_word,
            parent,
            false
        )
        return WordViewHolder(holderWordBinding)

    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    private fun getItem(position: Int): Word {
        return words[position]
    }

    override fun getItemCount(): Int {
        return words.size
    }

    fun addData(list: List<Word>) {
        this.words.clear()
        this.words.addAll(list)
        notifyDataSetChanged()
    }

    inner class WordViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

        fun onBind(word: Word) {
            val holderWordBinding = dataBinding as HolderWordBinding
            val wordViewModel = WordViewModel(word)
            holderWordBinding.wordViewModel = wordViewModel

            itemView.setOnClickListener {
                searchWordClickListener.showWordDetails(word)
            }

        }

    }

}
