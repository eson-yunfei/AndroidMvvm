package com.shon.android.net.viewmodel

import com.shon.android.net.NetApi
import com.shon.android.net.Request
import com.shon.scaffold.refresh.BaseRefreshLoadMoreViewModel

/**
 *
 * @Author xiao
 * @Data 2022-09-03 11:02
 */
open class NetRefreshLoadMoreViewModel<T> : BaseRefreshLoadMoreViewModel<T, NetApi>() {
    override fun getAPI(): NetApi = Request.getAPI()
}