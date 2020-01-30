package com.quebotic.sjchelp.utils

import android.content.Context
import com.quebotic.customprogressdialog.CommonValues
import com.thuongnh.zprogresshud.ZProgressHUD

class CustomProgressBar2(context: Context) {

    // mProgressBar: ZProgressHUD? = null
    var  mProgressBar = ZProgressHUD.getInstance(context)


     fun intProgressBar(aContext: Context,aProgressType:Int, aMessage: String) {
        mProgressBar = ZProgressHUD.getInstance(aContext)
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