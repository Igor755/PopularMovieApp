package com.test.domain.model


data class PopularMoviesModel(
    var page: Int,
    var results: List<MovieModel>,
    var totalResults: Int,
    var totalPages: Int)