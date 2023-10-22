package com.manuelapk.pelis.data.network.service

import com.manuelapk.pelis.data.model.PagedResult
import com.manuelapk.pelis.data.model.Response
import com.manuelapk.pelis.data.model.TimeWindow
import com.manuelapk.pelis.data.model.TrendingMovieApi
import com.manuelapk.pelis.data.network.api.MovieApi
import javax.inject.Inject

class MovieService @Inject constructor(
    private val api: MovieApi
) {
    suspend fun getMovies(time: TimeWindow): Response<PagedResult<TrendingMovieApi>?> {
        val response = api.getTrendingMovies(timeWindow = time.value)
        return if (response.isSuccessful) {
            Response.Successful(response.body())
        } else {
            Response.Error(message = response.message())
        }
    }
}