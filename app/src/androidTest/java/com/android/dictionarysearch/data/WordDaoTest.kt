package com.android.dictionarysearch.data


import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.dictionarysearch.data.source.local.AppDatabase
import com.android.dictionarysearch.domain.model.Word
import com.android.dictionarysearch.util.TestUtil
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class WordDaoTest {

    private lateinit var mDatabase: AppDatabase

    @Before
    fun createDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java
        )
            .build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        mDatabase.close()
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
            text = "Cat"
        }
        mDatabase.wordDao.insert(word)

        val wordLoadedByTitleTestSingle = mDatabase.wordDao.getWordByText("Cat").test()
        wordLoadedByTitleTestSingle.assertValue(word)

    }

    @Test
    @Throws(Exception::class)
    fun retrievesWords() {
        val wordList = TestUtil.makeWordList(5)
        wordList.forEach {
            mDatabase.wordDao.insert(it)
        }

        val loadedWordsTestSingle = mDatabase.wordDao.loadAll().test()
        loadedWordsTestSingle.assertValue(wordList)
    }

    @Test
    @Throws(Exception::class)
    fun deleteWord() {
        val word = TestUtil.createWord(8)
        mDatabase.wordDao.delete(word)

        val loadOneByWordIdTestSingle = mDatabase.wordDao.getWord(8).test()
        loadOneByWordIdTestSingle.assertNoValues()
    }

}