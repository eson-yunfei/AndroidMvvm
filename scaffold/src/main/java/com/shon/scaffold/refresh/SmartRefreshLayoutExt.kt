package com.shon.scaffold.refresh

import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener

/**
 *
 * @Author xiao
 * @Date 2022-09-02 11:12
 *
 */


fun SmartRefreshLayout.setRefreshListener(refresh: () -> Unit) {
    this.setOnRefreshListener {
        refresh.invoke()
    }
}

fun SmartRefreshLayout.setLoadMoreListener(loadMore: () -> Unit) {
    this.setOnLoadMoreListener {
        loadMore.invoke()
    }
}

fun SmartRefreshLayout.setAllListener(refresh: () -> Unit = {}, loadMore: () -> Unit = {}) {
    this.setOnRefreshLoadMoreListener(object : OnRefreshLoadMoreListener {
        override fun onRefresh(refreshLayout: RefreshLayout) {
            refresh.invoke()
        }

        override fun onLoadMore(refreshLayout: RefreshLayout) {
            loadMore.invoke()
        }

    })
}