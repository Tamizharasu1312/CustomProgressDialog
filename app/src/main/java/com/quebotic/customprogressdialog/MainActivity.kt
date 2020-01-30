package com.quebotic.customprogressdialog

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.quebotic.customprogressdialog.CommonValues.PROGRESSSUCCESS
import com.quebotic.sjchelp.utils.CustomProgressBar2
import com.thuongnh.zprogresshud.ZProgressHUD


class MainActivity : AppCompatActivity() {

    private var mbtShow: Button? = null
    private var mbtHide: Button? = null
    private var mContext: Context? = null

    //val progressBar = CustomProgressBar()
    val mProgressBar = CustomProgressBar()
    var progressHUD: ZProgressHUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this


        progressHUD = ZProgressHUD.getInstance(mContext)
        mbtShow = findViewById(R.id.bt_show)
        mbtHide = findViewById(R.id.bt_hide)

        mbtShow!!.setOnClickListener {
            /*progressHUD!!.setMessage("Please Wait...")
            progressHUD!!.setSpinnerType(2)
            progressHUD!!.show()*/

            CustomProgressBar2(mContext!!).intProgressBar(mContext!!,1,"Please Wait...")
            Handler().postDelayed({
                //progressHUD!!.dismissWithFailure("Spoil")
                CustomProgressBar2(mContext!!).dismissProgressbar(PROGRESSSUCCESS,PROGRESSSUCCESS)
            },3000)

        }
        mbtHide!!.setOnClickListener {
            Handler().postDelayed({
                //Dismiss progress bar after 4 seconds
                // progressBar.dialog.dismiss()
             //   mProgressBar.dismiss()
            }, 4000)
        }

    }
}
