package com.test.popularmovie.model


data class PopularMovies(
    var page: Int,
    var results: List<Movie>,
    var totalResults: Int,
    var totalPages: Int)