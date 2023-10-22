package com.manuelapk.pelis.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manuelapk.pelis.data.database.entities.TrendingMovieDb
import com.manuelapk.pelis.data.model.TimeWindow

@Dao
interface TrendingMovieDao {

    @Query("SELECT * FROM trending_movie_table where timeWindow = :timeWindow")
    suspend fun getAll(timeWindow: TimeWindow): List<TrendingMovieDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<TrendingMovieDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: TrendingMovieDb)

    @Query("DELETE FROM trending_movie_table where timeWindow = :timeWindow")
    suspend fun clearAll(timeWindow: TimeWindow)
}