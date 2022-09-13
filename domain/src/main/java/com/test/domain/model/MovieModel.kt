package com.test.domain.model

data class MovieModel (
    val posterPath: String? = null,
    val adult: Boolean? = null,
    val overview: String? = null,
    val release_date: String? = null,
    val genreIds: Array<Int>? = null,
    val id: Int,
    val originalTitle: String? = null,
    val originalLanguage: String? = null,
    val title: String? = null,
    val backdropPath: String? = null,
    val popularity: Double,
    val voteCount: Int? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieModel

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