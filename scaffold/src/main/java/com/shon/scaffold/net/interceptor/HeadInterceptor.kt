package com.shon.scaffold.net.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 *
 * @Author xiao
 * @Date 2022-09-02 12:09
 *
 */
class HeadInterceptor(val readHeader: Request.Builder.() -> Unit) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.addHeader("charset", "UTF-8")
        builder.readHeader()
        val request = builder.build()
        return chain.proceed(request)
    }
}