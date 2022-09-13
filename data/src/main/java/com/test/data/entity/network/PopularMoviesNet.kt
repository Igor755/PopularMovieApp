package com.test.data.entity.network

import com.google.gson.annotations.SerializedName

data class PopularMoviesNet(
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var results: List<MovieNet>,
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    var totalPages: Int)