package com.manuelapk.pelis.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.manuelapk.pelis.data.database.converters.Converter
import com.manuelapk.pelis.data.model.TimeWindow
import com.manuelapk.pelis.domain.Domain
import com.manuelapk.pelis.domain.model.TrendingMovie

@Entity("trending_movie_table")
data class TrendingMovieDb(
    @PrimaryKey val id: Long,
    val adult: Boolean,
    val backdropPath: String,
    val title: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val mediaType: String,
    @TypeConverters(Converter::class) val genreIDS: List<Long>,
    val popularity: Double,
    val releaseDate: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long,
    @TypeConverters(Converter::class) val timeWindow: TimeWindow
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

fun TrendingMovie.toDatabase(timeWindow: TimeWindow) = TrendingMovieDb(
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
    voteCount,
    timeWindow
)

