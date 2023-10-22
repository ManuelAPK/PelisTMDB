package com.manuelapk.pelis.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.manuelapk.pelis.data.database.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "pelis_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DataBase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideTrendingMovieDao(db: DataBase) = db.getTrendingMovieDao()
}