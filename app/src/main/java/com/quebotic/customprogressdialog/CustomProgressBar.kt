package com.quebotic.customprogressdialog


import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.webkit.WebView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import kotlinx.android.synthetic.main.custom_progress_layout_2.view.*


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

        dialog = Dialog(context, R.style.CustomProgressBarTheme)
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