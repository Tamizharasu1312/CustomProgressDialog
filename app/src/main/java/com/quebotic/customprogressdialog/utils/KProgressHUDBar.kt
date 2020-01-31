package com.quebotic.sjchelp.utils

import android.content.Context
import android.os.Handler
import com.kaopiz.kprogresshud.KProgressHUD


class KProgressHUDBar(context: Context) {

    var aKProgressHUD = KProgressHUD.create(context)


    fun intProgressBar(aProgressType: Int, aMessage: String) {
        aKProgressHUD.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setDimAmount(0.5f)
            .setLabel(aMessage)
        aKProgressHUD.show()
    }

    fun dismissProgressbar() {

        aKProgressHUD!!.dismiss()


    }

     fun scheduleDismiss() {
        val handler = Handler()
        handler.postDelayed({ aKProgressHUD.dismiss() }, 1000)
    }
}