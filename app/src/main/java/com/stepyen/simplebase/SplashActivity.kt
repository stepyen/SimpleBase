package com.stepyen.simplebase

import android.content.Intent
import com.stepyen.xui.activity.BaseSplashActivity

/**
 * date：2019-09-01
 * author：stepyen
 * description：
 *
 */
class SplashActivity : BaseSplashActivity() {
    override fun onCreateActivity() {
        startSplash(true)
    }

    override fun onSplashFinished() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}