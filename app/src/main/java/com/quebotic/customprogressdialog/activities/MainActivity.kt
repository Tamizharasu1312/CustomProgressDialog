package com.quebotic.customprogressdialog.activities

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kaopiz.kprogresshud.KProgressHUD
import com.quebotic.customprogressdialog.R
import com.quebotic.customprogressdialog.utils.CustomAVProgressBar
import com.quebotic.customprogressdialog.utils.CustomProgressBar
import com.quebotic.customprogressdialog.utils.ProgressDialogs
import com.thuongnh.zprogresshud.ZProgressHUD


class MainActivity : AppCompatActivity() {

    private var mbtShow: Button? = null
    private var mbtHide: Button? = null
    private var mContext: Context? = null

    //val progressBar = CustomProgressBar()
    val mProgressBar = CustomProgressBar()
    var progressHUD: ZProgressHUD? = null
    var mKProgressHUD: KProgressHUD? = null
    val mPBAVProgress = CustomAVProgressBar()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this


        progressHUD = ZProgressHUD.getInstance(mContext)

        mKProgressHUD = KProgressHUD.create(mContext)

        mbtShow = findViewById(R.id.bt_show)
        mbtHide = findViewById(R.id.bt_hide)

        mbtShow!!.setOnClickListener {

            mPBAVProgress.show(
                this,
                "Please Wait..."
            )

            Handler().postDelayed({
                mPBAVProgress.dismissWithSuccess("Success")
                //  progressBar!!.dialog.dismiss()
            }, 500)
         /*   *//*progressHUD!!.setMessage("Please Wait...")
            progressHUD!!.setSpinnerType(2)
            progressHUD!!.show()*//*

            //ZProgressHUDBar(mContext!!).intProgressBar(1,"Please Wait...")
            // KProgressHUDBar(mContext!!).intProgressBar(1,"Please Wait...")


            *//*  mKProgressHUD!!.setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                  .setDimAmount(0.5f)
                  .setLabel("Please Wait...")
              mKProgressHUD!!.show()*//*

            //ProgressDialogFragment.newInstance("I AM TITLE!!").show(supportFragmentManager, "ProgressDialogs")

            var progressDialog = ProgressDialogs()
            progressDialog.show(supportFragmentManager, "Yummy Fresh Fruits")

            Handler().postDelayed({
                //progressHUD!!.dismissWithFailure("Spoil")
                //ZProgressHUDBar(mContext!!).dismissProgressbar(PROGRESSSUCCESS,PROGRESSSUCCESS)
                //  KProgressHUDBar(mContext!!).dismissProgressbar()
                //KProgressHUDBar(mContext!!).scheduleDismiss()
                //mKProgressHUD!!.dismiss()
            }, 3000)
*/
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
