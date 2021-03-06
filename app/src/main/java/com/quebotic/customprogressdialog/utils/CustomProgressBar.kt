package com.quebotic.customprogressdialog.utils


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.NonNull
import com.quebotic.customprogressdialog.R


class CustomProgressBar {
    lateinit var dialog: Dialog
    var myLoadingTxt: TextView? = null

    @SuppressLint("InflateParams")
    fun show(context: Context, title: CharSequence?): Dialog {
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflator.inflate(R.layout.custom_progress_layout, null)

        myLoadingTxt = view.findViewById(R.id.custom_loadingtext_TV) as TextView
        val myProgressWheel = view.findViewById(R.id.custom_dialog_box_PB) as ProgressBar
        if (title != null) {
            myLoadingTxt!!.text = title
        }
        // view.cp_bg_view.setBackgroundColor(Color.parseColor("#60000000")) //Background Color
        // view.cp_cardview.setCardBackgroundColor(Color.parseColor("#70000000")) //Box Color
        // setColorFilter(view.cp_pbar.indeterminateDrawable, ResourcesCompat.getColor(context.resources, R.color.colorPrimary, null)) //Progress Bar Color
        // myLoadingTxt.setTextColor(Color.BLACK) //Text Color

        dialog = Dialog(context,
            R.style.CustomProgressBarTheme
        )
        dialog.setContentView(view)
        dialog.show()

        return dialog
    }

    fun dismiss() {
        dialog.hide()
        dialog.dismiss()
    }


    fun setColorFilter(@NonNull drawable: Drawable, color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            drawable.colorFilter = BlendModeColorFilter(color, BlendMode.SRC_ATOP)
        } else {
            @Suppress("DEPRECATION")
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
    }
}