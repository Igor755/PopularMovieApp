package com.test.data.extensions

import com.test.data.entity.network.GenericNet
import com.test.data.entity.room.GenericEntity
import com.test.domain.model.GenericModel
import com.test.domain.model.MovieModel
import com.test.domain.model.PopularMoviesModel
import com.test.data.entity.network.MovieNet
import com.test.data.entity.network.PopularMoviesNet

fun List<GenericNet>.mapGenericNet() = this.mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun GenericEntity.map() = GenericModel(id)

fun GenericNet.map() = GenericModel(id)

fun List<GenericEntity>.mapGenericEntity() = mapTo(
    mutableListOf(), {
        it.map()
    }
)

fun List<GenericModel>.mapToGenericEntity() = mapTo(mutableListOf(), {
    it.map()
})

fun GenericModel.map() = GenericEntity(id)

fun MovieNet.map() = MovieModel(  posterPath, adult, overview, release_date, genreIds, id, originalTitle, originalLanguage, title, backdropPath, popularity, voteCount, video, voteAverage)

fun MovieModel.map() = MovieNet(  posterPath, adult, overview, release_date, genreIds, id, originalTitle, originalLanguage, title, backdropPath, popularity, voteCount, video, voteAverage)

fun PopularMoviesNet.map() = PopularMoviesModel(page, results.mapNet(), totalResults, totalPages)

fun PopularMoviesModel.map() = PopularMoviesNet(page, results.mapModel(), totalResults, totalPages)

fun List<MovieNet>.mapNet() = mapTo(mutableListOf()) {
    it.map()
}

fun List<MovieModel>.mapModel() = mapTo(mutableListOf()) {
    it.map()
}

