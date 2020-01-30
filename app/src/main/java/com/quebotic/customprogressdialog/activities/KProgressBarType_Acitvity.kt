package com.quebotic.customprogressdialog.activities

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kaopiz.kprogresshud.KProgressHUD
import com.quebotic.customprogressdialog.R


class KProgressBarType_Acitvity : AppCompatActivity() ,View.OnClickListener{


    private var mContext: Context? = null

    private var hud: KProgressHUD? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kprogress_types_layout)
        mContext = this

        val indeterminate: Button = findViewById(R.id.indeterminate) as Button
        indeterminate.setOnClickListener(this)

        val labelIndeterminate: Button = findViewById(R.id.label_indeterminate) as Button
        labelIndeterminate.setOnClickListener(this)

        val detailIndeterminate: Button = findViewById(R.id.detail_indeterminate) as Button
        detailIndeterminate.setOnClickListener(this)

        val graceIndeterminate: Button = findViewById(R.id.grace_indeterminate) as Button
        graceIndeterminate.setOnClickListener(this)

        val determinate: Button = findViewById(R.id.determinate) as Button
        determinate.setOnClickListener(this)

        val annularDeterminate: Button = findViewById(R.id.annular_determinate) as Button
        annularDeterminate.setOnClickListener(this)

        val barDeterminate: Button = findViewById(R.id.bar_determinate) as Button
        barDeterminate.setOnClickListener(this)

        val customView: Button = findViewById(R.id.custom_view) as Button
        customView.setOnClickListener(this)

        val dimBackground: Button = findViewById(R.id.dim_background) as Button
        dimBackground.setOnClickListener(this)

        val customColor: Button = findViewById(R.id.custom_color_animate) as Button
        customColor.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.indeterminate -> {
                hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                scheduleDismiss()
            }
            R.id.label_indeterminate -> {
                hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("Please wait")
                    .setCancellable(DialogInterface.OnCancelListener {
                        fun onCancel(dialogInterface: DialogInterface?) {
                            Toast.makeText(
                                this@KProgressBarType_Acitvity, "You " +
                                        "cancelled manually!", Toast.LENGTH_SHORT
                            ).show()
                        }
                    })
                scheduleDismiss()
            }
            R.id.detail_indeterminate -> {
                hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setLabel("Please wait")
                    .setDetailsLabel("Downloading data")
                scheduleDismiss()
            }
            R.id.grace_indeterminate -> {
                hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setGraceTime(1000)
                scheduleDismiss()
            }
            R.id.determinate -> {
                hud = KProgressHUD.create(this@KProgressBarType_Acitvity)
                    .setStyle(KProgressHUD.Style.PIE_DETERMINATE)
                    .setLabel("Please wait")
                simulateProgressUpdate()
            }
            R.id.annular_determinate -> {
                hud = KProgressHUD.create(this@KProgressBarType_Acitvity)
                    .setStyle(KProgressHUD.Style.ANNULAR_DETERMINATE)
                    .setLabel("Please wait")
                    .setDetailsLabel("Downloading data")
                simulateProgressUpdate()
            }
            R.id.bar_determinate -> {
                hud = KProgressHUD.create(this@KProgressBarType_Acitvity)
                    .setStyle(KProgressHUD.Style.BAR_DETERMINATE)
                    .setLabel("Please wait")
                simulateProgressUpdate()
            }
            R.id.custom_view -> {
                val imageView = ImageView(this)
                imageView.setBackgroundResource(R.drawable.spin_animation)
                val drawable: AnimationDrawable = imageView.getBackground() as AnimationDrawable
                drawable.start()
                hud = KProgressHUD.create(this)
                    .setCustomView(imageView)
                    .setLabel("This is a custom view")
                scheduleDismiss()
            }
            R.id.dim_background -> {
                hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setDimAmount(0.5f)
                scheduleDismiss()
            }
            R.id.custom_color_animate -> {
                hud = KProgressHUD.create(this)
                    .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                    .setWindowColor(resources.getColor(R.color.colorPrimary))
                    .setAnimationSpeed(2)
                scheduleDismiss()
            }
        }
        hud!!.show()
    }
    private fun simulateProgressUpdate() {
        hud!!.setMaxProgress(100)
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            var currentProgress = 0
            override fun run() {
                currentProgress += 1
                hud!!.setProgress(currentProgress)
                if (currentProgress == 80) {
                    hud!!.setLabel("Almost finish...")
                }
                if (currentProgress < 100) {
                    handler.postDelayed(this, 50)
                }
            }
        }, 100)
    }
    private fun scheduleDismiss() {
        val handler = Handler()
        handler.postDelayed({ hud!!.dismiss() }, 2000)
    }
}
