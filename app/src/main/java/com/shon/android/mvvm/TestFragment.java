package com.shon.android.mvvm;

import android.os.Bundle;

import com.shon.android.mvvm.databinding.ActivityMainBinding;
import com.shon.mvvm.base.ui.BaseBindingFragment;

import org.jetbrains.annotations.Nullable;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/7 23:36
 * Package name : com.shon.android.mvvm
 * Des :
 */
class TestFragment extends BaseBindingFragment<ActivityMainBinding> {

    @Override
    public void onProcess(@Nullable Bundle savedInstanceState) {
        super.onProcess(savedInstanceState);
//        binding.text.setText("11111111");
    }
}
