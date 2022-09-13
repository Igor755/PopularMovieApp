package com.test.popularmovie.ui.main.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.test.popularmovie.R
import kotlinx.android.synthetic.main.dialog_network.*

class NoInternetDialogFragment : DialogFragment() {

    var onRetryClickListener: (() -> Unit)? = null
    var allowDismiss = false
    var isShowing = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.bg_rounded_item_white)
        return inflater.inflate(R.layout.dialog_network, container, false)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        isShowing = false
        if (!allowDismiss)
            activity?.finishAffinity()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.setCancelable(false)

        isShowing = true

        btnExitFromApp.setOnClickListener {
            allowDismiss = true
            activity?.finishAffinity()
        }

        btnTryAgain.setOnClickListener {
            allowDismiss = true
            onRetryClickListener?.invoke()
        }
    }
}