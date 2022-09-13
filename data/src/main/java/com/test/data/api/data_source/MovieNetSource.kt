package com.test.data.api.data_source

import com.test.data.api.service.MovieApi
import com.test.data.entity.network.PopularMoviesNet
import com.test.data.extensions.map
import com.test.domain.exception.NetworkErrorException
import com.test.domain.model.PopularMoviesModel
import com.test.domain.throwException
import org.koin.core.KoinComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieNetSource(private val movieApi: MovieApi){

    fun getPopularMovies(
        page: Int,
        onComplete: (popularMoviesModel: PopularMoviesModel) -> Unit,
        onError: (Exception) -> Unit
    ) {
        val hashmap = HashMap<String, String>()
        hashmap["Authorization"] = "Bearer ${"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NTczNzc2NjJiNzVmYmJhZGFkYjEwZjYyZDk4ZDYyMSIsInN1YiI6IjYzMWYxMTkwMGQyZjUzMDA4NDJhMjZlOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XWVco5vbmuP7HZjj_oV5Ul8KWl2-FnniuLvKSfRkmY4"}"
        movieApi.getPopularMovies(hashmap, page)
            .enqueue(object : Callback<PopularMoviesNet> {
                override fun onFailure(call: Call<PopularMoviesNet>, t: Throwable) {
                    onError(NetworkErrorException())
                }

                override fun onResponse(
                    call: Call<PopularMoviesNet>,
                    response: Response<PopularMoviesNet>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            onComplete(it.map())
                        }
                    } else {
                        onError(response.code().throwException(response.message()))
                    }
                }
            })
    }
}