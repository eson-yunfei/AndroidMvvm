package com.shon.scaffold.net.exception

/**
 *
 * @Author xiao
 * @Date 2022-09-02 15:44
 *
 */
enum class NetError(val message: String) {

    /**
     * 未知错误
     */
    UNKNOWN("请求失败，请稍后再试"),

    /**
     * 解析错误
     */
    PARSE_ERROR("解析错误，请稍后再试"),

    /**
     * 网络错误
     */
    NETWORK_ERROR("网络连接错误，请稍后重试"),

    /**
     * 证书出错
     */
    SSL_ERROR("证书出错，请稍后再试"),

    /**
     * 连接超时
     */
    TIMEOUT_ERROR("网络连接超时，请稍后重试");

}