package com.test.popularmovie.ui.main

import android.os.Bundle
import com.test.popularmovie.R
import com.test.popularmovie.common.BaseActivity
import com.test.popularmovie.extension.navigateTo
import com.test.popularmovie.ui.main.fragment.PopularMoviesFragment

class MainActivity : BaseActivity(R.layout.activity_main){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateTo(
            R.id.fragment_container,
            PopularMoviesFragment(),
            byFade = true
        )
    }
}









