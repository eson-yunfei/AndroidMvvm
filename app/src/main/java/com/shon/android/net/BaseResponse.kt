package com.shon.android.net

import com.shon.scaffold.net.response.NetResponse

/**
 *
 * @Author xiao
 * @Date 2022-09-02 17:33
 *
 */
data class BaseResponse<T>(val data: T, val errorCode: Int, val errorMsg: String) :
    NetResponse<T>() {
    override fun isResponseSuccess(): Boolean {
        return errorCode == 0
    }

    override fun getResponseCode(): Int {
        return errorCode
    }

    override fun getResponseData(): T? {
        return data
    }

    override fun getResponseMsg(): String? {
        return errorMsg
    }

}
