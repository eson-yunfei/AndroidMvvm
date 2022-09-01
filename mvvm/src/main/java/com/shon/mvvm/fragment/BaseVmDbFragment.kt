package com.shon.mvvm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.interfaces.DataBindingInterface
import com.shon.mvvm.interfaces.IPageCreate

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:55
 *
 */
abstract class BaseVmDbFragment<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmFragment<VM>(),
    DataBindingInterface<DB>{
    lateinit var dataBinding: DB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = createDataBinding(this, inflater, container)
        return dataBinding.root
    }

}