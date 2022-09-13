package com.test.popularmovie.model

data class Movie (
    val posterPath: String? = null,
    val adult: Boolean? = null,
    val overview: String? = null,
    val release_date: String? = null,
    val genreIds: Array<Int>? = null,
    val id: Int,
    val originalTitle: String? = null,
    val originalLanguage: String? = null,
    val title: String? = null,
    val backdropPath: String? = null,
    val popularity: Double,
    val voteCount: Int? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null
)