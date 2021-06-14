package com.android.dictionarysearch.data.source.local.dao


import androidx.room.*
import com.android.dictionarysearch.domain.model.Word
import io.reactivex.Single

/**
 * it provides access to [Word] underlying database
 * */
@Dao
interface WordDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(word: Word): Long
//
//    @Query("SELECT * FROM Word")
//    fun loadAll(): MutableList<Word>
//
//    @Delete
//    fun delete(word: Word)
//
//    @Query("DELETE FROM Word")
//    fun deleteAll()
//
//    @Query("SELECT * FROM Word where id = :meaningId")
//    fun getWordMeaning(meaningId: Long): Single<Word.Meaning>
//
//    @Query("SELECT * FROM Word where text = :wordTitle")
//    fun loadOneByWordText(wordTitle: String): Word?
//
//    @Update
//    fun update(word: Word)

}