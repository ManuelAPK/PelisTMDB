package com.manuelapk.pelis.data.repository

import com.manuelapk.pelis.data.database.dao.TrendingMovieDao
import com.manuelapk.pelis.data.database.entities.TrendingMovieDb
import com.manuelapk.pelis.data.model.Response
import com.manuelapk.pelis.data.model.TimeWindow
import com.manuelapk.pelis.data.network.service.MovieService
import com.manuelapk.pelis.domain.model.TrendingMovie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieService: MovieService,
    private val trendingMovieDao: TrendingMovieDao
) {
    suspend fun getTrendingMoviesFromNetwork(
        timeWindow: TimeWindow
    ): Response<List<TrendingMovie>?> {
        val response = movieService.getMovies(timeWindow)
        return if (response is Response.Successful) {
            Response.Successful(data = response.data?.results?.map { it.toDomain() })
        } else {
            Response.Error(message = (response as? Response.Error)?.message ?: "Error API")
        }
    }

    suspend fun getTrendingMoviesDatabase(timeWindow: TimeWindow): List<TrendingMovie> {
        val response: List<TrendingMovieDb> = trendingMovieDao.getAll(timeWindow)
        return response.map { it.toDomain() }
    }

    suspend fun clearAllTrendingMovies(timeWindow: TimeWindow) {
        trendingMovieDao.clearAll(timeWindow)
    }

    suspend fun insertTrendingMovies(movies: List<TrendingMovieDb>) {
        trendingMovieDao.insertAll(movies)
    }

}