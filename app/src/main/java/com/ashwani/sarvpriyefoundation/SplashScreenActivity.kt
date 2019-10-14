package com.ashwani.sarvpriyefoundation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class SplashScreenActivity : AppCompatActivity() {
    internal var pStatus = 0
    private val handler = Handler()
    internal lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val drawable = ContextCompat.getDrawable(this, R.drawable.circular)
        val mProgress = findViewById<View>(R.id.circularProgressbar) as ProgressBar
        mProgress.progress = 0   // Main Progress
        mProgress.secondaryProgress = 100 // Secondary Progress
        mProgress.max = 100 // Maximum Progress
        mProgress.progressDrawable = drawable


        Thread(Runnable {
            while (pStatus < 100) {
                pStatus += 1

                handler.post {
                    mProgress.progress = pStatus
                    if (mProgress.progress == mProgress.max)
                        startActivity(Intent(this, MainActivity::class.java))
                }
                try {
                    Thread.sleep(16)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }).start()

    }
}
