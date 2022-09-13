package com.test.popularmovie.extension

import com.test.popularmovie.model.Generic
import com.test.domain.model.GenericModel
import com.test.domain.model.MovieModel
import com.test.domain.model.PopularMoviesModel
import com.test.popularmovie.model.Movie
import com.test.popularmovie.model.PopularMovies

fun List<GenericModel>.mapGeneric() = this.mapTo(mutableListOf(), {
    it.map()
})

fun GenericModel.map() = Generic(
    id = id
)

fun Movie.map() = MovieModel(  posterPath, adult, overview, release_date, genreIds, id, originalTitle, originalLanguage, title, backdropPath, popularity, voteCount, video, voteAverage)

fun MovieModel.map() = Movie(  posterPath, adult, overview, release_date, genreIds, id, originalTitle, originalLanguage, title, backdropPath, popularity, voteCount, video, voteAverage)

fun PopularMovies.map() = PopularMoviesModel(page, results.map(), totalResults, totalPages)

fun PopularMoviesModel.map() = PopularMovies(page, results.mapModel(), totalResults, totalPages)

fun List<Movie>.map() = mapTo(mutableListOf()) {
    it.map()
}

fun List<MovieModel>.mapModel() = mapTo(mutableListOf()) {
    it.map()
}

