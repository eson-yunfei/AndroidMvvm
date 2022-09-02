package com.shon.android.net.response

/**
 *
 * @Author xiao
 * @Date 2022-09-02 17:41
 *
 */
data class PageBean<T>(
    val curPage:Int,
    val offset:Int,
    val pageCount:Int,
    val total:Int,
    val size:Int,
    val datas:MutableList<T>,
)
