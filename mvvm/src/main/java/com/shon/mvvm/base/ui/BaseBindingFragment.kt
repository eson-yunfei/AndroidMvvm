package com.shon.mvvm.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.shon.mvvm.base.imp.ICreate

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 23:38
 * Package name : com.shon.mvvm.base.ui
 * Des :
 */
abstract class BaseBindingFragment<Binding> : Fragment(), ICreate {
    @JvmField
    protected var binding: Binding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (layoutID == 0) {
            binding = BindingUtil.createBinding(this, inflater, container)
            (binding as ViewBinding?)!!.root
        } else {
            binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutID, container, false) as Binding
            (binding as ViewDataBinding?)!!.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewState()
        initViewListener()
        onProcess(savedInstanceState)
    }

    override val layoutID: Int
        get() = 0

    override fun initViewState() {}
    override fun initViewListener() {}
    override fun onProcess(savedInstanceState: Bundle?) {}
}