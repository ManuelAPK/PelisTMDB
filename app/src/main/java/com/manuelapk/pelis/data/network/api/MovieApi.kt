package com.manuelapk.pelis.data.network.api

import com.manuelapk.pelis.BuildConfig
import com.manuelapk.pelis.data.model.PagedResult
import com.manuelapk.pelis.data.model.TrendingMovieApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("trending/movie/{time_window}")
    suspend fun getTrendingMovies(
        @Path("time_window") timeWindow: String,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Response<PagedResult<TrendingMovieApi>>

}