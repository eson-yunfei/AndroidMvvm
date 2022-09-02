package com.shon.scaffold.net.ssl

import android.annotation.SuppressLint
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

/**
 *
 * @Author xiao
 * @Date 2022-09-02 12:02
 *
 */
class TrustAllHostnameVerifier: HostnameVerifier {
    @SuppressLint("BadHostnameVerifier")
    override fun verify(hostname: String?, session: SSLSession?): Boolean {
        return true
    }
}