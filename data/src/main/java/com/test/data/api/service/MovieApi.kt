package com.test.data.api.service

import com.test.data.constant.ApiEndpoints
import com.test.data.entity.network.PopularMoviesNet
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface MovieApi {
    @GET(ApiEndpoints.GET_POPULAR_MOVIES)
    fun getPopularMovies(@HeaderMap headers: HashMap<String, String>,  @Query("page") page: Int): Call<PopularMoviesNet>
}