package com.shon.web

import androidx.viewbinding.ViewBinding
import com.just.agentweb.AgentWeb
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.activity.BaseVmVbActivity

/**
 *
 * @Author xiao
 * @Date 2022-09-06 15:22
 *
 */
abstract class BaseWebActivity<VM : BaseViewModel, VB : ViewBinding> : BaseVmVbActivity<VM, VB>(),
    WebViewObserver {
    override fun onInitView() {
        super.onInitView()
        lifecycle.addObserver(this)
    }

    override var mAgentWeb: AgentWeb? = null

    override fun getAgentWeb(): AgentWeb.AgentBuilder {
        return AgentWeb.with(this)
    }


}