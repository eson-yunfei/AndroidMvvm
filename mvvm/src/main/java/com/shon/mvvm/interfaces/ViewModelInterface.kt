package com.shon.mvvm.interfaces

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.GetObjects

/**
 *  ViewModel 的实现接口
 * @Author xiao
 * @Date 2022-09-01 16:18
 *
 */
internal interface ViewModelInterface<VM : BaseViewModel> {

    /**
     * 创建 ViewModel 并且绑定 ViewModel
     */
    fun onAttachView(lifecycleOwner: LifecycleOwner, factory: ViewModelProvider.Factory): VM {

        val viewMode = factory.create<VM>(GetObjects.getVMClazz(this))
        viewMode.onAttach(lifecycleOwner)
        return viewMode
    }
}