package com.shon.android.mvvm.viewmodels

import com.shon.android.net.response.ArticleBean
import com.shon.android.net.viewmodel.NetRefreshLoadMoreViewModel

/**
 *
 * @Author xiao
 * @Date 2022-09-01 17:15
 *
 */
class MainViewModel : NetRefreshLoadMoreViewModel<ArticleBean>() {

    private var currentPage: Int = 0

    fun startRefreshData() {
        currentPage = 0
        loadHomeArticleBean {
            refreshLiveData.postValue(it)
        }
    }

    fun startLoadMoreData() {
        loadHomeArticleBean {
            loadMoreLiveData.postValue(it)
        }

    }

    override fun upgradePageIndex() {
        currentPage += 1
    }

    private fun loadHomeArticleBean(data: (MutableList<ArticleBean>) -> Unit) {
        requestData({
            getAPI().articleList(currentPage)
        }, {
            data.invoke(it?.datas ?: mutableListOf())
        })
    }
}