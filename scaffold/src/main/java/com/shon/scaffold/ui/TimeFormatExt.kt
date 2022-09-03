package com.shon.scaffold.ui

import android.icu.text.SimpleDateFormat
import java.util.*

/**
 *
 * @Author xiao
 * @Data 2022-09-03 11:39
 */
fun Long.toTimeString(pattern: String): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return simpleDateFormat.format(Date(this))
}

fun String.timeToLong(pattern: String):Long{
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    val date = simpleDateFormat.parse(this)
    return date.time
}