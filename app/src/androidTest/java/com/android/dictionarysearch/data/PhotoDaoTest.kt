package com.android.dictionarysearch.data

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.android.dictionarysearch.data.source.local.AppDatabase
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.util.TestUtil
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class WordDaoTest {

    private lateinit var mDatabase: AppDatabase

    @Before
    fun createDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getTargetContext(), AppDatabase::class.java)
            .build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDatabase.close()
    }

    @Test
    @Throws(Exception::class)
    fun isWordListEmpty(){
        assertEquals(0,mDatabase.wordDao.loadAll().size)
    }

    @Test
    @Throws(Exception::class)
    fun insertWord() {
        val word: Word = TestUtil.createWord(7)
        val insertedWord = mDatabase.wordDao.insert(word)
        assertNotNull(insertedWord)
    }

    @Test
    @Throws(Exception::class)
    fun insertWordAndLoadByTitle() {
        val word: Word = TestUtil.createWord(1).apply {
            setName("Art")
        }
        mDatabase.wordDao.insert(word)
        val wordLoadedByTitle = mDatabase.wordDao.getWordByTitle("Art")
        assertThat(wordLoadedByTitle, equalTo(word))
    }

    @Test
    @Throws(Exception::class)
    fun retrievesWords(){
        val wordList = TestUtil.makeWordList(5)
        wordList.forEach {
            mDatabase.wordDao.insert(it)
        }

        val loadedWords = mDatabase.wordDao.loadAll()
        assertEquals(wordList,loadedWords)
    }

    @Test
    @Throws(Exception::class)
    fun deleteWord(){
        val word = TestUtil.createWord(8)
        mDatabase.wordDao.delete(word)

        val loadOneByWordId = mDatabase.wordDao.getWord(8)
        assertNull(loadOneByWordId)
    }

    @Test
    @Throws(Exception::class)
    fun deleteAllWords(){
        mDatabase.wordDao.deleteAll()
        val loadedAllWords = mDatabase.wordDao.loadAll()
        assert(loadedAllWords.isEmpty())
    }


}