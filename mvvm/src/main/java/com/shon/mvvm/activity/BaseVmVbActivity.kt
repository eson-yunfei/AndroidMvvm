package com.shon.mvvm.activity

import androidx.viewbinding.ViewBinding
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.interfaces.ViewBindingInterface

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:34
 *
 */
open class BaseVmVbActivity<VM : BaseViewModel, VB : ViewBinding> : BaseVmActivity<VM>(),
    ViewBindingInterface<VB> {

    lateinit var viewBinding: VB
    override fun onInitView() {
        viewBinding = createViewBinding(layoutInflater)
        setContentView(viewBinding.root)
    }


}
