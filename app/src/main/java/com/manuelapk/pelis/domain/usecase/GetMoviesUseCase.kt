package com.manuelapk.pelis.domain.usecase

import com.manuelapk.pelis.data.database.entities.toDatabase
import com.manuelapk.pelis.data.model.PagedResult
import com.manuelapk.pelis.data.model.Response
import com.manuelapk.pelis.data.model.TimeWindow
import com.manuelapk.pelis.data.model.TrendingMovieApi
import com.manuelapk.pelis.data.repository.MovieRepository
import com.manuelapk.pelis.domain.model.TrendingMovie
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(timeWindow: TimeWindow): Response<List<TrendingMovie>> {
        return try {
            val response = movieRepository.getTrendingMoviesFromNetwork(timeWindow)
            if(response is Response.Successful && response.data != null){
                movieRepository.clearAllTrendingMovies(timeWindow)
                movieRepository.insertTrendingMovies(response.data.map { it.toDatabase(timeWindow) })
              return Response.Successful(response.data)
            }
            val responseDb = movieRepository.getTrendingMoviesDatabase(timeWindow)
            return Response.Successful(responseDb)

        } catch (e: Exception) {
            Response.Error(e.message ?: "Generic error")
        }
    }
}