package com.shon.android.net

import com.shon.android.net.response.ArticleBean
import com.shon.android.net.response.PageBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @Author xiao
 * @Date 2022-09-02 17:32
 *
 */
interface NetApi {

    @GET("article/list/{index}/json")
    suspend fun articleList(@Path("index") index: Int = 0): BaseResponse<PageBean<ArticleBean>>
}