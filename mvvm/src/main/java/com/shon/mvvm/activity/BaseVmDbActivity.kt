package com.shon.mvvm.activity

import androidx.databinding.ViewDataBinding
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.interfaces.DataBindingInterface

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:39
 *
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>(),
    DataBindingInterface<DB> {
    lateinit var dataBinding: DB

    override fun onInitView() {
        dataBinding = createDataBinding(this)
    }

}