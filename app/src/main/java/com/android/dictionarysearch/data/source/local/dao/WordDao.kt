package com.android.dictionarysearch.data.source.local.dao


import androidx.room.*
import com.android.dictionarysearch.domain.model.Word
import io.reactivex.Single

/**
 * it provides access to [Word] underlying database
 * */
@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word): Long

    @Query("SELECT * FROM Word")
    fun loadAll(): Single<MutableList<Word>?>

    @Delete
    fun delete(word: Word)

    @Query("DELETE FROM Word")
    fun deleteAll()

    @Query("SELECT * FROM Word where id = :id")
    fun getWord(id: Long): Single<Word?>

    @Query("SELECT * FROM Word where text = :wordTitle")
    fun getWordByText(wordTitle: String): Single<Word?>

    @Update
    fun update(word: Word)

}