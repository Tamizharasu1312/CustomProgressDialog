package com.quebotic.sjchelp.utils

import android.content.Context
import com.kaopiz.kprogresshud.KProgressHUD
import com.quebotic.customprogressdialog.CommonValues
import com.thuongnh.zprogresshud.ZProgressHUD

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


}