package com.quebotic.customprogressdialog.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.quebotic.customprogressdialog.R
import kotlinx.android.synthetic.main.custom_dialog_progress.view.*

class ProgressDialogFragment: DialogFragment() {
    private lateinit var mTitle: String

    companion object {
        private const val ARG_TITLE = "TITLE"

        fun newInstance(title: String): ProgressDialogFragment {
            val progressDialogFragment = ProgressDialogFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            progressDialogFragment.arguments = args
            return progressDialogFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mTitle = arguments?.getString(ARG_TITLE)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val rootView = inflater.inflate(R.layout.custom_dialog_progress, container, false)

        rootView.custom_loadingtext_TV.text = mTitle

        return rootView
    }
}