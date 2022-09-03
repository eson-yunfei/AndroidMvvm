package com.shon.android.net

import com.shon.scaffold.net.BaseNetRequest
import okhttp3.logging.HttpLoggingInterceptor

/**
 *
 * @Author xiao
 * @Date 2022-09-02 17:31
 *
 */
class Request:BaseNetRequest<NetApi>("https://www.wanandroid.com/") {

    companion object{

        val request:Request by lazy { Request() }
        fun getAPI():NetApi{
            return request.getApi()
        }
    }
    override fun enableSSL(): Boolean {
        return true
    }

    override fun setHttpLoggingInterceptor(httpLoggingInterceptor: HttpLoggingInterceptor) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}