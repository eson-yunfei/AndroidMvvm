package com.shon.android.net

import com.shon.scaffold.net.BaseNetViewModel

open class NetViewModel:BaseNetViewModel<NetApi>() {
    override fun getAPI(): NetApi {
        return Request.getAPI()
    }
}