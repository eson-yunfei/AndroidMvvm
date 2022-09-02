package com.shon.scaffold.net.exception

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

/**
 *
 * @Author xiao
 * @Date 2022-09-02 15:47
 *
 */

fun Throwable.handleThrowable(): NetError {
    return when (this) {
        is HttpException, is ConnectException -> NetError.NETWORK_ERROR
        is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> NetError.PARSE_ERROR
        is javax.net.ssl.SSLException -> NetError.SSL_ERROR
        is java.net.SocketTimeoutException, is java.net.UnknownHostException -> NetError.TIMEOUT_ERROR
        else -> NetError.UNKNOWN
    }
}