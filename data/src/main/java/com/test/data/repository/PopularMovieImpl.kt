package com.test.data.repository

import com.test.data.api.data_source.MovieNetSource
import com.test.domain.model.PopularMoviesModel
import com.test.domain.repository.PopularMoviesRepository

class PopularMovieImpl(private val movieNetSource: MovieNetSource) : PopularMoviesRepository{

    override suspend fun getPopularMovies(
        page : Int,
        onSuccess: (PopularMoviesModel?) -> Unit,
        onError: (Exception) -> Unit
    ) {
        movieNetSource.getPopularMovies(page, onSuccess, onError)
    }
}