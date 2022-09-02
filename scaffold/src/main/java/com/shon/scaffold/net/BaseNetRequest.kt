package com.shon.scaffold.net

import android.content.res.Resources
import com.shon.scaffold.net.interceptor.HeadInterceptor
import com.shon.scaffold.net.ssl.addSSL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.ParameterizedType
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:56
 *
 */
open class BaseNetRequest<T>(private val baseUrl: String) {

    fun getApi(): T {
        val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .client(okHttpClient)
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit = setRetrofitBuilder(retrofitBuilder).build()
        return retrofit.create(getTClazz(this))

    }

    open fun getBaseUrl(): String {
        return baseUrl
    }

    private val okHttpClient: OkHttpClient
        get() {
            val okHttpClientBuilder = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)

            return setClient(okHttpClientBuilder).build()
        }

    open fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder {
        return builder
    }

    open fun setClient(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        if (enableSSL()) {
            builder.addSSL()
        }
        val httpLogger = HttpLoggingInterceptor()
        setHttpLoggingInterceptor(httpLogger)
        builder.addInterceptor(httpLogger)
        createHeadInterceptor()?.let {
            builder.addInterceptor(it)
        }
        return builder
    }

    open fun enableSSL(): Boolean {
        return false
    }

    open fun createHeadInterceptor(): HeadInterceptor? {
        return null
    }

    open fun setHttpLoggingInterceptor(httpLoggingInterceptor: HttpLoggingInterceptor) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getTClazz(obj: Any): T {
        val parameterizedType = obj.javaClass.genericSuperclass as ParameterizedType
        val actualTypeArguments = parameterizedType.actualTypeArguments
        if (actualTypeArguments.isEmpty()) {
            throw Resources.NotFoundException("未找到 接口文件")
        }
        return actualTypeArguments[0] as T
    }
}