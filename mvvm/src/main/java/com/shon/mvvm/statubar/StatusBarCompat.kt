//@file:Suppress("DEPRECATION")

package com.shon.mvvm.statubar

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.core.view.ViewCompat


/**
 *
 * @Author xiao
 * @Data 2022-09-03 12:15
 */
object StatusBarCompat {

    @Suppress("DEPRECATION")
    fun translucentStatusBar(activity: Activity, hideStatusBarBackground: Boolean) {
        val window: Window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (hideStatusBarBackground) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = Color.TRANSPARENT
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }

        kotlin.runCatching {
            val mChildView: View? =
                window.findViewById<ViewGroup>(Window.ID_ANDROID_CONTENT).getChildAt(0)
            mChildView
        }.onSuccess { mChildView ->
            mChildView?.let {
                ViewCompat.setFitsSystemWindows(it, false)
                ViewCompat.requestApplyInsets(it)
            }
        }


    }

    @Suppress("DEPRECATION")
    fun changeToLightStatusBar(activity: Activity) {
        val window = activity.window ?: return
        val decorView = window.decorView
        decorView.systemUiVisibility =
            decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    @Suppress("DEPRECATION")
    fun cancelLightStatusBar(activity: Activity) {

        val window = activity.window ?: return
        val decorView = window.decorView
        decorView.systemUiVisibility =
            decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    }
}