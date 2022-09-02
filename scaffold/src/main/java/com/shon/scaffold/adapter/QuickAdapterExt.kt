package com.shon.scaffold.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import org.eson.slog.logD
import org.eson.slog.logE

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:24
 *
 */

/**
 *
 */
fun <T> BaseQuickAdapter<T, *>.itemDoubleClick(
    timeDelay: Long = 500L,
    listener: (item: T, position: Int) -> Unit
) {
    var lastClickTime = 0L
    this.setOnItemClickListener { _, _, position ->
        val des = System.currentTimeMillis() - lastClickTime
        if (des < timeDelay) {
            return@setOnItemClickListener
        }
        lastClickTime = System.currentTimeMillis()

        kotlin.runCatching {
            this.data[position]
        }.onSuccess {
            listener.invoke(it, position)
        }.onFailure {
            logE("setOnItemDoubleClick: $it")
        }
    }
}

fun <T> BaseQuickAdapter<T, *>.itemChildDoubleClick(
    timeDelay: Long = 500L,
    listener: (item: T, view: View, position: Int) -> Unit
) {
    var lastClickTime = 0L
    this.setOnItemChildClickListener { _, view, position ->
        val des = System.currentTimeMillis() - lastClickTime
        logD("setItemChildDoubleClickListener des = $des")
        if (des < timeDelay) {
            return@setOnItemChildClickListener
        }
        lastClickTime = System.currentTimeMillis()

        kotlin.runCatching {
            this.data[position]
        }.onSuccess {
            listener.invoke(it, view, position)
        }.onFailure {
            logE("setOnItemDoubleClick: $it")
        }
    }
}

