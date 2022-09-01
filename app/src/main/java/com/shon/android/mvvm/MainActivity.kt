package com.shon.android.mvvm

import android.util.Log
import com.shon.android.mvvm.databinding.ActivityMainBinding
import com.shon.mvvm.BaseViewModel
import com.shon.mvvm.activity.BaseVmDbActivity

class MainActivity : BaseVmDbActivity<BaseViewModel,ActivityMainBinding>(){

     class ClickProxy{

        fun onSingeExtent(){
            Log.d("MainActivity", "onSingeExtent: ")
        }
    }

    override fun onInitData() {
        dataBinding.mainModel = ClickProxy()
    }
    override fun getDataBindingLayoutId(): Int {
        return R.layout.activity_main
    }
}