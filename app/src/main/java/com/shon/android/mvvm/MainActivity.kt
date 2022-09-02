package com.shon.android.mvvm

import android.content.Intent
import android.view.View
import com.shon.android.mvvm.databinding.ActivityMainBinding
import com.shon.android.mvvm.viewmodels.MainViewModel
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.activity.BaseVmDbActivity

class MainActivity : BaseVmDbActivity<MainViewModel, ActivityMainBinding>() {

    override fun onInitData() {
        dataBinding.mainModel = ClickProxy()
    }

    override fun getDataBindingLayoutId(): Int {
        return R.layout.activity_main
    }


    internal class ClickProxy {

        fun onSingeExtent(view:View) {
            view.context.startActivity(Intent(view.context,ViewBindingActivity::class.java))
        }
    }
}