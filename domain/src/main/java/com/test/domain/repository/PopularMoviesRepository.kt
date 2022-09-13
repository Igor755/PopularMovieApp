package com.test.domain.repository

import com.test.domain.model.PopularMoviesModel

interface PopularMoviesRepository {
    suspend fun getPopularMovies(
        page : Int,
        onSuccess: (PopularMoviesModel?) -> Unit,
        onError: (Exception) -> Unit
    )
}