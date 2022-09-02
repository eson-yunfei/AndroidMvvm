package com.shon.android.net

import com.shon.android.net.response.ArticleBean
import com.shon.android.net.response.PageBean
import retrofit2.http.GET

/**
 *
 * @Author xiao
 * @Date 2022-09-02 17:32
 *
 */
interface NetApi {

    @GET("article/list/0/json")
    suspend fun articleList(): BaseResponse<PageBean<ArticleBean>>
}