package com.shon.mvvm.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.interfaces.IPageCreate
import com.shon.mvvm.interfaces.ViewModelInterface

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:21
 *
 */
open class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity(), ViewModelInterface<VM>,
    IPageCreate {
    lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        onPreCreateView()
        super.onCreate(savedInstanceState)
        viewModel = onAttachView(this, defaultViewModelProviderFactory)
        onInitView()
        onInitListener()
        onInitData()
    }

    override fun onInitView() {
    }

    override fun onInitListener() {
    }

    override fun onInitData() {
    }

}