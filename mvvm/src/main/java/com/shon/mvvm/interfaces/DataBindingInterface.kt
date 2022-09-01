package com.shon.mvvm.interfaces

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:19
 *
 */
internal interface DataBindingInterface<DB : ViewDataBinding> {
    fun createDataBinding(activity: AppCompatActivity): DB {
        val dataBinding: DB = DataBindingUtil.setContentView(activity, getDataBindingLayoutId())
        dataBinding.lifecycleOwner = activity
        return dataBinding
    }


    fun createDataBinding(
        fragment: Fragment,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): DB {
        val dataBinding: DB =
            DataBindingUtil.inflate(inflater, getDataBindingLayoutId(), container, false)
        dataBinding.lifecycleOwner = fragment
        return dataBinding
    }

    fun getDataBindingLayoutId(): Int
}