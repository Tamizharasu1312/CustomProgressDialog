package com.quebotic.customprogressdialog.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.annotation.SuppressLint
import android.os.Handler
import android.widget.TextView
import com.quebotic.customprogressdialog.R
import kotlinx.android.synthetic.main.custom_av_progress_bar_layout.view.*


class CustomAVProgressBar {

    lateinit var dialog: Dialog

    var aMessageTV: TextView? = null

    fun show(context: Context): Dialog {
        return show(context, null)
    }

    @SuppressLint("InflateParams")
    fun show(context: Context, title: CharSequence?): Dialog {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.custom_av_progress_bar_layout, null)
        aMessageTV = view.findViewById(R.id.message_tv)
        if (title != null) {
            aMessageTV!!.text = title
        }
        view.cp_bg_view.setBackgroundColor(Color.parseColor("#60000000")) //Background Color
        view.cp_cardview.setCardBackgroundColor(Color.parseColor("#70000000")) //Box Color
        aMessageTV!!.setTextColor(Color.WHITE) //Text Color

        dialog = Dialog(context, R.style.CustomProgressBarTheme)
        dialog.setContentView(view)
        dialog.show()

        return dialog
    }

    fun dismissWithSuccess(aMessage: String) {
        aMessageTV!!.text = aMessage
        Handler().postDelayed({
            dialog.dismiss()
        }, 2000)
    }

    fun dismissWithFailure(aMessage: String) {
        aMessageTV!!.text = aMessage

        Handler().postDelayed({
            dialog.dismiss()
        }, 2000)
    }
}