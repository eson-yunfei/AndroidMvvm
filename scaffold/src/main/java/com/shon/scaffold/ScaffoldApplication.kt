package com.shon.scaffold

import android.app.Application
import com.shon.scaffold.data.initMMKV
import org.eson.slog.SLogConfig
import org.eson.slog.SLogManager

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:27
 *
 */
open class ScaffoldApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initMMKV()
        initSlog()
    }

    private fun initSlog() {
        val path: String? = getExternalFilesDir("log")?.path
        SLogManager.sLogManager.setConfig(SLogConfig().config {
            setIncludeThread(true)
            setStackTraceDepth(1)
            setSaveFile(true, path ?: "")
        })
    }

    fun registerActivityLifecycle(callback: ActivityLifecycles) {
        registerActivityLifecycleCallbacks(callback)
    }
}