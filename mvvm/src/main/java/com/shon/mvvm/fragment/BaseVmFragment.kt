package com.shon.mvvm.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.interfaces.IPageCreate
import com.shon.mvvm.interfaces.ViewModelInterface

/**
 *
 * @Author xiao
 * @Date 2022-09-01 16:48
 *
 */
open class BaseVmFragment<VM : BaseViewModel> : Fragment(), ViewModelInterface<VM> , IPageCreate {
    private lateinit var viewModel: VM
    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = onAttachView(this, defaultViewModelProviderFactory)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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