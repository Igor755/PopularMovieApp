package com.test.popularmovie.common

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.test.popularmovie.common.receivers.InternetConnectionBroadcastReceiver
import com.test.popularmovie.ui.main.dialog.NoInternetDialogFragment

open class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    private var networkChangeReceiver: InternetConnectionBroadcastReceiver? = null
    private var noInternetDialogFragment: NoInternetDialogFragment? = null
    private var internetState: Boolean? = true

    var fragmentOnInternetChangeListener: ((connected: Boolean) -> Unit)? = null

    private fun stopListening() {
        internetState = true
        try {
            unregisterReceiver(networkChangeReceiver)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun showNoInternetDialog() {
        if (noInternetDialogFragment == null) {
            noInternetDialogFragment = NoInternetDialogFragment().apply {
                onRetryClickListener = {
                    fragmentOnInternetChangeListener?.invoke(true)
                }
            }
            if (noInternetDialogFragment?.isShowing != true && !noInternetDialogFragment?.isAdded!!) {
                val manager: FragmentManager? = supportFragmentManager
                if (manager != null) {
                    val ft: FragmentTransaction = manager.beginTransaction()
                    val fragment: Fragment? =
                        manager.findFragmentByTag(NoInternetDialogFragment::class.java.name)
                    if (fragment != null) {
                        ft.remove(fragment)
                    }
                    ft.addToBackStack(null)
                    noInternetDialogFragment?.show(ft, NoInternetDialogFragment::class.java.name)
                }
            }
        }
    }

    fun hideNoInternetDialog() {
        if (noInternetDialogFragment?.isShowing == true && noInternetDialogFragment?.isAdded!!) {
            noInternetDialogFragment?.allowDismiss = true
            noInternetDialogFragment?.dismiss()
        }
        noInternetDialogFragment = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkChangeReceiver = InternetConnectionBroadcastReceiver {
            if (internetState != it) {
                internetState = it
                fragmentOnInternetChangeListener?.invoke(it)
                if (!it) {
                    showNoInternetDialog()
                } else {
                    hideNoInternetDialog()
                }
            }
        }
        startListeningInternetConnection()
    }

    private fun startListeningInternetConnection() {
        stopListening()
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(networkChangeReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        stopListening()
    }
}