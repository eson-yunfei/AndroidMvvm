package com.shon.android.mvvm

import android.annotation.SuppressLint
import android.os.Bundle
import com.shon.android.mvvm.Base2.Base2Activity
import com.shon.android.mvvm.databinding.ActivityMainBinding
import com.shon.android.mvvm.databinding.DatabindLaytBinding

class MainActivity : Base2Activity<DatabindLaytBinding?, MyViewModel?>() {
    @SuppressLint("SetTextI18n")
    override fun onProcess(savedInstanceState: Bundle?) {
//        binding!!.text.text = "111111111"
    }


    override val layoutID: Int
        get() = R.layout.databind_layt
}