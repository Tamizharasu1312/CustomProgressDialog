package com.quebotic.sjchelp.utils

import android.content.Context
import com.quebotic.customprogressdialog.utils.CommonValues
import com.thuongnh.zprogresshud.ZProgressHUD

class ZProgressHUDBar(context: Context) {

    var mProgressBar = ZProgressHUD.getInstance(context)


     fun intProgressBar(aProgressType:Int, aMessage: String) {
        mProgressBar!!.setSpinnerType(aProgressType)
        mProgressBar!!.setMessage(aMessage)
        mProgressBar!!.show()
    }

     fun dismissProgressbar(aType: String, aMessage: String) {
        when (aType) {

            CommonValues.PROGRESSSUCCESS -> {
                mProgressBar!!.dismissWithSuccess(aMessage)
            }
            CommonValues.PROGRESSFAILURE -> {
                mProgressBar!!.dismissWithFailure(aMessage)
            }

        }

    }

}