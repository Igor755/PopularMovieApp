package com.test.popularmovie.common.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.test.popularmovie.extension.isNetworkConnected
import java.lang.RuntimeException

class InternetConnectionBroadcastReceiver(private val onConnectionUpdate: ((Boolean) -> Unit)? =null) :
    BroadcastReceiver() {
    override fun onReceive(ctx: Context?, p1: Intent?) {
        try {
            onConnectionUpdate?.invoke(ctx?.isNetworkConnected() ?: false)
        } catch (e : RuntimeException) {}
    }

}