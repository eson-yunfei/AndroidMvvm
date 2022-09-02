package com.shon.scaffold.net.ssl

import okhttp3.OkHttpClient
import java.security.SecureRandom
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory

/**
 *
 * @Author xiao
 * @Date 2022-09-02 12:02
 *
 */

fun OkHttpClient.Builder.addSSL() {
    kotlin.runCatching {
        createSSLSocketFactory()
    }.onSuccess {
        sslSocketFactory(it, TrustAllCerts())
        hostnameVerifier(TrustAllHostnameVerifier())
    }

}

fun createSSLSocketFactory(): SSLSocketFactory {
    val sc: SSLContext = SSLContext.getInstance("TLS")
    sc.init(
        null, arrayOf(
            TrustAllCerts()
        ), SecureRandom()
    )
    return sc.socketFactory
}