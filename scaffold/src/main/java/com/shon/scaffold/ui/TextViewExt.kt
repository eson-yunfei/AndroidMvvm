package com.shon.scaffold.ui

import android.annotation.SuppressLint
import android.widget.TextView

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:11
 *
 */


@SuppressLint("UseCompatLoadingForDrawables")
fun TextView.setLeftDrawables(id: Int) {

    val drawable = context.getDrawable(id)
    drawable!!.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    setCompoundDrawables(drawable, null, null, null)
}


@SuppressLint("UseCompatLoadingForDrawables")
fun TextView.setRightDrawables(id: Int) {

    val drawable = context.getDrawable(id)
    drawable!!.setBounds(0, 0, drawable.minimumWidth, drawable.minimumHeight)
    setCompoundDrawables(null, null, null, drawable)
}