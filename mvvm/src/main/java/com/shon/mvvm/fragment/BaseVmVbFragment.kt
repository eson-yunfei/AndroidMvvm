package com.shon.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.GetObjects
import com.shon.mvvm.interfaces.ViewBindingInterface

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:52
 *
 */
open class BaseVmVbFragment<VM : BaseViewModel, VB : ViewBinding> : BaseVmFragment<VM>(),
    ViewBindingInterface<VB> {

    lateinit var viewBinding: VB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = GetObjects.getVBInstance(this, inflater)
        return viewBinding.root
    }

}