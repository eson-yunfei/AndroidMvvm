package com.shon.android.mvvm.viewmodels

import com.shon.android.net.Request
import com.shon.scaffold.net.NetViewModel

/**
 *
 * @Author xiao
 * @Date 2022-09-01 17:15
 *
 */
class MainViewModel : NetViewModel() {

    fun loadHomeArticleBean() {
        requestData({
            Request.getAPI().articleList()
        }, {

        })
    }
}