package com.shon.mvvm.interfaces

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.shon.mvvm.GetObjects

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:19
 *
 */
internal interface ViewBindingInterface<VB : ViewBinding> {

    fun createViewBinding(inflater: LayoutInflater): VB {
        return GetObjects.getVBInstance(this, inflater)
    }
}