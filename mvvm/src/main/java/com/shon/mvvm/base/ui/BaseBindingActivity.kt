package com.shon.mvvm.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import com.shon.mvvm.BindingUtil
import com.shon.mvvm.base.imp.IActivityCreate

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 22:04
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseBindingActivity<Binding> : AppCompatActivity(), IActivityCreate {
    @JvmField
    protected var binding: Binding? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        //super 之前需要执行的代码
        onPreSuperCreate()
        super.onCreate(savedInstanceState)

        //在 setContentView 之前 需要调用 的代码
        onPreSetContentView()
        setBindingLayout()
        initViewState()
        initViewListener()
        onProcess(savedInstanceState)
    }

    /**
     * 初始化  ViewBinding 或者 ViewDataBinding
     * 并且 setContentView
     */
    private fun setBindingLayout() {
        if (layoutID == 0) {
            binding = BindingUtil.createBinding(this)
            if (binding == null) {
                throw NullPointerException("binding is null")
            }
            setContentView((binding as ViewBinding).root)
        } else {
            binding = DataBindingUtil.setContentView<ViewDataBinding>(this, layoutID) as Binding
            setContentView((binding as ViewDataBinding?)!!.root)
        }
    }

    override val layoutID: Int
        get() = 0

    override fun onPreSuperCreate() {}
    override fun onPreSetContentView() {}
    override fun initViewState() {}
    override fun initViewListener() {}
}