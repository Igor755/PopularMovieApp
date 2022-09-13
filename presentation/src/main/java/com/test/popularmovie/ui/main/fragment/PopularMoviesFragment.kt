package com.test.popularmovie.ui.main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.chad.library.adapter.base.diff.BaseQuickDiffCallback
import com.test.domain.model.Result
import com.test.popularmovie.R
import com.test.popularmovie.model.Movie
import com.test.popularmovie.ui.main.adapter.PopularMoviesAdapter
import com.test.popularmovie.ui.main.viewmodel.PopularMoviesViewModel
import kotlinx.android.synthetic.main.fragment_popular_movie.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class PopularMoviesFragment : Fragment(R.layout.fragment_popular_movie) {

    private val popularMoviesAdapter: PopularMoviesAdapter by inject()
    private val popularMoviesViewModel: PopularMoviesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
    }

    private fun initViews(){
        rv_popular_movies.adapter = popularMoviesAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObservers(){
        pw_fragment_bottom_nav_channel.spin()
        popularMoviesViewModel.getPopularMovies()
        popularMoviesViewModel.popularMoviesLiveData.observe(viewLifecycleOwner, Observer {result->
            when(result){
                is Result.Success ->{
                    setNewData(result.data!!)
                    pw_fragment_bottom_nav_channel.stopSpinning()
                }
                is Result.Error -> {
                    pw_fragment_bottom_nav_channel.stopSpinning()
                    Toast.makeText(context, "Ups, error", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setNewData(newData: List<Movie>) {
        popularMoviesAdapter.setNewDiffData(object : BaseQuickDiffCallback<Movie>(newData) {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem.id == newItem.id
                        && oldItem.posterPath == newItem.posterPath
                        && oldItem.adult == newItem.adult
                        && oldItem.overview == newItem.overview
                        && oldItem.release_date == newItem.release_date
                        && oldItem.genreIds.contentEquals(newItem.genreIds)
                        && oldItem.originalTitle == newItem.originalTitle
                        && oldItem.originalLanguage == newItem.originalLanguage
                        && oldItem.title == newItem.title
                        && oldItem.backdropPath == newItem.backdropPath
                        && oldItem.popularity == newItem.popularity
                        && oldItem.voteCount == newItem.voteCount
                        && oldItem.video == newItem.video
                        && oldItem.voteAverage == newItem.voteAverage
            }
        })
    }
}