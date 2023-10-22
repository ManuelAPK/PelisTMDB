package com.manuelapk.pelis.data.model

import com.manuelapk.pelis.data.database.DatabaseEntity
import com.manuelapk.pelis.data.database.entities.TrendingMovieDb
import com.manuelapk.pelis.domain.Domain
import com.manuelapk.pelis.domain.model.TrendingMovie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingMovieApi(
    val adult: Boolean,
    @SerialName("backdrop_path")
    val backdropPath: String,
    val id: Long,
    val title: String,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("original_title")
    val originalTitle: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String,
    @SerialName("media_type")
    val mediaType: String,
    @SerialName("genre_ids")
    val genreIDS: List<Long>,
    val popularity: Double,
    @SerialName("release_date")
    val releaseDate: String,
    val video: Boolean,
    @SerialName("vote_average")
    val voteAverage: Double,
    @SerialName("vote_count")
    val voteCount: Long
) : Domain<TrendingMovie> {

    override fun toDomain(): TrendingMovie = TrendingMovie(
        id,
        adult,
        backdropPath,
        title,
        originalLanguage,
        originalTitle,
        overview,
        posterPath,
        mediaType,
        genreIDS,
        popularity,
        releaseDate,
        video,
        voteAverage,
        voteCount
    )
}
