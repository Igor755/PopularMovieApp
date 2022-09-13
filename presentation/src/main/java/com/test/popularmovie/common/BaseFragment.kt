package com.test.popularmovie.common

import androidx.fragment.app.Fragment

open class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    fun setOnConnectionChangeListener(listener: (connected: Boolean) -> Unit) {
        if (activity is BaseActivity) {
            (activity as BaseActivity?)?.fragmentOnInternetChangeListener = listener
        }
    }
}