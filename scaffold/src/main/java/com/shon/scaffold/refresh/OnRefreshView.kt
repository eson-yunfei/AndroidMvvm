package com.shon.scaffold.refresh

/**
 *
 * @Author xiao
 * @Data 2022-09-03 10:17
 */
interface OnRefreshView<T> {
    fun onNoData()
    fun onRefreshData(data: MutableList<T>)
}
