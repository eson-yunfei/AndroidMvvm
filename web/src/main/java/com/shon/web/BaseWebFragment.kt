package com.shon.web

import androidx.viewbinding.ViewBinding
import com.just.agentweb.AgentWeb
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.fragment.BaseVmVbFragment

/**
 *
 * @Author xiao
 * @Date 2022-09-06 16:39
 *
 */
abstract class BaseWebFragment<VM:BaseViewModel,VB:ViewBinding>:BaseVmVbFragment<VM,VB>() ,WebViewObserver{

    override var mAgentWeb: AgentWeb? = null

    override fun getAgentWeb(): AgentWeb.AgentBuilder {
        return AgentWeb.with(this)
    }

    override fun onInitView() {
        lifecycle.addObserver(this)
    }
}