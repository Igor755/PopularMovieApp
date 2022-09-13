package com.test.domain.interactor

import com.test.domain.model.PopularMoviesModel
import com.test.domain.repository.PopularMoviesRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class PopularMoviesInteractor  : KoinComponent  {

   private val popularMoviesRepository: PopularMoviesRepository by inject()

    suspend fun getPopularMovies(
        page : Int,
        onComplete: (PopularMoviesModel?) -> Unit,
        onError: (Exception) -> Unit
    ) = popularMoviesRepository.getPopularMovies(page, onComplete, onError)

}