package com.shon.mvvm.statubar

import android.app.Activity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 *
 * @Author xiao
 * @Data 2022-09-03 12:28
 */
interface StatusBarLifeCycle : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        val activity = getActivity()
        if (transparentStatusBar()) {
            //透明状态栏,取消状态栏的阴影
            StatusBarCompat.translucentStatusBar(activity, true)
        }
        if (darkStatusBar()) {
            //将状态栏改为深色模式(状态栏 icon 和字体会变成浅色, 即默认模式)
            StatusBarCompat.changeToLightStatusBar(activity)
        }
    }

    fun transparentStatusBar(): Boolean {
        return false
    }

    /**
     * 状态栏字体颜色是否为深色
     */
    fun darkStatusBar(): Boolean {
        return false
    }

    fun getActivity(): Activity
}