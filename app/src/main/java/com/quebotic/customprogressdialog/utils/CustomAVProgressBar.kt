package com.quebotic.customprogressdialog.utils

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.widget.TextView
import com.quebotic.customprogressdialog.R
import com.quebotic.customprogressdialog.activities.MainActivity
import kotlinx.android.synthetic.main.custom_av_progress_bar_layout.view.*


class CustomAVProgressBar(context: Context) {

    lateinit var dialog: Dialog

    val mContext = context
    var aMessageTV: TextView? = null

    fun show(context: Context): Dialog {
        return show(mContext, null)
    }

    @SuppressLint("InflateParams")
    fun show(context: Context, title: CharSequence?): Dialog {
        val inflator = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.custom_av_progress_bar_layout, null)
        aMessageTV = view.findViewById(R.id.message_tv)
        if (title != null) {
            aMessageTV!!.text = title
        }
        view.cp_bg_view.setBackgroundColor(Color.parseColor("#60000000")) //Background Color
        view.cp_cardview.setCardBackgroundColor(Color.parseColor("#70000000")) //Box Color
        aMessageTV!!.setTextColor(Color.WHITE) //Text Color

        dialog = Dialog(mContext, R.style.CustomProgressBarTheme)
        dialog.setContentView(view)
        dialog.show()

        return dialog
    }

    fun dismissWithSuccess(aMessage: String) {
      //  aMessageTV!!.text = aMessage
        dialog.dismiss()

    }
    fun setProgressMessage(aMessage: String){
        if (aMessage != null) {
            aMessageTV!!.text = aMessage
        }
    }

    fun dismissWithFailure(aMessage: String) {
        aMessageTV!!.text = aMessage
        Handler().postDelayed({
            dialog.dismiss()
        }, 2000)
    }

    fun dismissProgressbar(
        aType: String,
        aMessage: String
    ) {
        when (aType) {

            CommonValues.PROGRESSSUCCESS -> {

                dialog.dismiss()
              //  dismissWithSuccess(aMessage)
            }
            CommonValues.PROGRESSFAILURE -> {
                dismissWithFailure(aMessage)

            }

        }

    }

}