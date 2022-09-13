package com.test.popularmovie.di

import com.test.domain.interactor.GenericInteractor
import com.test.domain.interactor.PopularMoviesInteractor
import com.test.popularmovie.ui.main.adapter.PopularMoviesAdapter
import com.test.popularmovie.ui.main.viewmodel.PopularMoviesViewModel
import org.koin.dsl.module

val adaptersModule = module {
    factory { PopularMoviesAdapter() }
}

val viewModelsModule = module {
    factory { PopularMoviesViewModel(get()) }
}

val interactorsModule = module {
    factory { GenericInteractor() }
    factory { PopularMoviesInteractor() }
}

