package com.manuelapk.pelis.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.manuelapk.pelis.data.database.converters.Converter
import com.manuelapk.pelis.data.database.dao.TrendingMovieDao
import com.manuelapk.pelis.data.database.entities.TrendingMovieDb

@Database(
    entities = [
        TrendingMovieDb::class
    ],
    version = 1
)
@TypeConverters(Converter::class)
abstract class DataBase: RoomDatabase() {

    abstract fun getTrendingMovieDao():TrendingMovieDao
}