package com.quebotic.customprogressdialog.helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Handler
import com.quebotic.customprogressdialog.utils.CommonValues
import com.quebotic.customprogressdialog.utils.CustomAVProgressBar

interface SHelper {


    private fun aStartActivity(context: Context,activity: Activity,mPBAVProgress:CustomAVProgressBar){
        Handler().postDelayed({
            mPBAVProgress.dismissProgressbar(
                CommonValues.PROGRESSSUCCESS,
                CommonValues.PROGRESSSUCCESS
            )
            context.startActivity(Intent(context, activity::class.java))
        }, 2000)


    }
}