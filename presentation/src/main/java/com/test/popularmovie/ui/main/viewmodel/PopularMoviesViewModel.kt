package com.test.popularmovie.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.interactor.PopularMoviesInteractor
import com.test.domain.model.Result
import com.test.popularmovie.extension.mapModel
import com.test.popularmovie.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PopularMoviesViewModel (private val interactor: PopularMoviesInteractor) : ViewModel(){

    private val _popularMoviesLiveData = MutableLiveData<Result<List<Movie>>>()
    val popularMoviesLiveData: LiveData<Result<List<Movie>>> = _popularMoviesLiveData

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getPopularMovies(1, {
                _popularMoviesLiveData.value = Result.Success(it?.results?.mapModel())
            }) {
                _popularMoviesLiveData.postValue(Result.Error(it))
            }
        }
    }
}