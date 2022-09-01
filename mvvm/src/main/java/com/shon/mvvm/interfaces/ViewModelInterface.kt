package com.shon.mvvm.interfaces

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.GetObjects

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:18
 *
 */
internal interface ViewModelInterface<VM : BaseViewModel> {

    fun onAttachView(lifecycleOwner: LifecycleOwner, factory: ViewModelProvider.Factory): VM {

        val viewMode = factory.create<VM>(GetObjects.getVMClazz(this))
        viewMode.onAttach(lifecycleOwner)
        return viewMode
    }
}