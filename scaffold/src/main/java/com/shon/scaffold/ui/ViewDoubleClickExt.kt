package com.shon.scaffold.ui

import android.view.View

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:07
 *
 */

/**
 * 控件 防连点
 *
 * @param timeDelay : 连续点击 时间间隔，默认 500 ms
 * @param click :点击事件回调
 */
fun View.doubleClick(timeDelay: Long = 500L, click: (View) -> Unit) {
    var lastClickTime = 0L
    this.setOnClickListener {
        if (System.currentTimeMillis() - lastClickTime < timeDelay) {
            return@setOnClickListener
        }
        lastClickTime = System.currentTimeMillis()
        click.invoke(it)
    }
}

/**
 * View 多次点击后，执行事件
 *
 * @param times : 点击次数，
 */
fun View.moreClick(times: Int = 5, click: () -> Unit) {
    val timeDelay = 1000
    var currentTimes = 0
    var lastClickTime = 0L
    this.setOnClickListener {
        if (System.currentTimeMillis() - lastClickTime > timeDelay) {
            currentTimes = 1
        } else {
            currentTimes += 1
        }
        lastClickTime = System.currentTimeMillis()
        if (currentTimes >= times) {
            currentTimes = 0
            click.invoke()
        }

    }
}


