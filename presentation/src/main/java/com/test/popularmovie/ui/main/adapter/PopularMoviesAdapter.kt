package com.test.popularmovie.ui.main.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.test.popularmovie.R
import com.test.popularmovie.model.Movie
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMoviesAdapter : BaseQuickAdapter<Movie, BaseViewHolder>(R.layout.item_popular_movie) {

    override fun convert(holder: BaseViewHolder, item: Movie) {
        item.let { movie ->
                holder.itemView.tv_average.text = movie.voteAverage.toString()
                holder.itemView.tv_original_language.text = movie.originalLanguage
                holder.itemView.tv_original_title.text = movie.originalTitle
                holder.itemView.tv_popularity.text = movie.popularity.toString()
        }
    }
}