package com.shon.scaffold.data

import android.app.Application
import android.content.Context
import android.os.Parcelable
import com.tencent.mmkv.MMKV
import org.eson.slog.logD

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:30
 *
 */


fun Application.initMMKV() {
    val rootPath = MMKV.initialize(this)
    logD("initMMKV -->> rootPath = $rootPath")
}
fun initMMKV(context: Context) {
    val rootPath = MMKV.initialize(context)
    logD("initMMKV -->> rootPath = $rootPath")
}
fun getDefaultMMKV(): MMKV {
    return MMKV.defaultMMKV(MMKV.MULTI_PROCESS_MODE,"")
}
fun String.clearMMKK() = with(getDefaultMMKV()){
    removeValueForKey(this@clearMMKK)
}

fun <T> String.saveMMKVData(t: T) = with(getDefaultMMKV()) {
    when (t) {
        is Int -> encode(this@saveMMKVData, t)
        is Long -> encode(this@saveMMKVData, t)
        is Float -> encode(this@saveMMKVData, t)
        is String -> encode(this@saveMMKVData, t)
        is Boolean -> encode(this@saveMMKVData, t)
        is Parcelable -> encode(this@saveMMKVData, t)
        else -> throw IllegalStateException("This is not saved")
    }
}


inline fun <reified T> String.getMMKVData(default: T): T? = with(getDefaultMMKV()) {
    val value :Any?= when (default) {
        is Int ->  decodeInt(this@getMMKVData, default)
        is Long -> decodeLong(this@getMMKVData, default)
        is Float -> decodeFloat(this@getMMKVData, default)
        is String -> decodeString(this@getMMKVData, default)
        is Boolean -> decodeBool(this@getMMKVData, default)
        is Parcelable -> {
            decodeParcelable(this@getMMKVData, T::class.java as Class<Parcelable>)
        }
        else -> throw IllegalStateException("This is not saved")
    }

    return value as T?
}
