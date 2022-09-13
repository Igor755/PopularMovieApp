package com.test.data.entity.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieNet (
    @SerializedName("poster_path")
    @Expose
    val posterPath: String? = null,

    @SerializedName("adult")
    @Expose
    val adult: Boolean? = null,

    @SerializedName("overview")
    @Expose
    val overview: String? = null,

    @SerializedName("release_date")
    @Expose
    val release_date: String? = null,

    @SerializedName("genre_ids")
    @Expose
    val genreIds: Array<Int>? = null,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String? = null,

    @SerializedName("original_language")
    @Expose
    val originalLanguage: String? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String? = null,

    @SerializedName("popularity")
    @Expose
    val popularity: Double,

    @SerializedName("voteCount")
    @Expose
    val voteCount: Int? = null,

    @SerializedName("video")
    @Expose
    val video: Boolean? = null,

    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieNet

        if (posterPath != other.posterPath) return false
        if (adult != other.adult) return false
        if (overview != other.overview) return false
        if (release_date != other.release_date) return false
        if (genreIds != null) {
            if (other.genreIds == null) return false
            if (!genreIds.contentEquals(other.genreIds)) return false
        } else if (other.genreIds != null) return false
        if (id != other.id) return false
        if (originalTitle != other.originalTitle) return false
        if (originalLanguage != other.originalLanguage) return false
        if (title != other.title) return false
        if (backdropPath != other.backdropPath) return false
        if (popularity != other.popularity) return false
        if (voteCount != other.voteCount) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = posterPath?.hashCode() ?: 0
        result = 31 * result + (adult?.hashCode() ?: 0)
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (release_date?.hashCode() ?: 0)
        result = 31 * result + (genreIds?.contentHashCode() ?: 0)
        result = 31 * result + id
        result = 31 * result + (originalTitle?.hashCode() ?: 0)
        result = 31 * result + (originalLanguage?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (voteCount ?: 0)
        result = 31 * result + (video?.hashCode() ?: 0)
        result = 31 * result + (voteAverage?.hashCode() ?: 0)
        return result
    }
}