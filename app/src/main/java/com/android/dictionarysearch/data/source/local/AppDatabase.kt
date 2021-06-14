package com.android.dictionarysearch.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.dictionarysearch.data.source.local.dao.WordDao
import com.android.dictionarysearch.domain.model.Word

/**
 * To manage data items that can be accessed, updated
 * & maintain relationships between them
 */
@Database(entities = [Word::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val wordDao: WordDao

    companion object {
        const val DB_NAME = "DictionarySearchDatabase.db"
    }

}
