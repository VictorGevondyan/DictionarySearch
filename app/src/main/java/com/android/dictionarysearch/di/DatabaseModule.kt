package com.android.dictionarysearch.di

import android.app.Application
import androidx.room.Room
import com.android.dictionarysearch.data.source.local.AppDatabase
import com.android.dictionarysearch.data.source.local.dao.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    fun provideWordDao(appDatabase: AppDatabase): WordDao {
        return appDatabase.wordDao
    }

}