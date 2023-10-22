package com.manuelapk.pelis.domain.model

import androidx.room.PrimaryKey

data class TrendingMovie(
    val id: Long,
    val adult: Boolean,
    val backdropPath: String,
    val title: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val mediaType: String,
    val genreIDS: List<Long>,
    val popularity: Double,
    val releaseDate: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Long
)
