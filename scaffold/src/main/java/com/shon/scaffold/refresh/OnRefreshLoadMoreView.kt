package com.shon.scaffold.refresh

/**
 *
 * @Author xiao
 * @Data 2022-09-03 10:17
 */
interface OnRefreshLoadMoreView<T> : OnRefreshView<T> {
    fun onNoMoreData()
    fun onMoreData(data: MutableList<T>)
}