package com.shon.scaffold.net.response

/**
 *
 * @Author xiao
 * @Date 2022-09-02 12:05
 *
 */
abstract class NetResponse<T> {
    abstract fun isResponseSuccess():Boolean
    abstract fun getResponseCode(): Int
    abstract fun getResponseData(): T?
    abstract fun getResponseMsg(): String?
}