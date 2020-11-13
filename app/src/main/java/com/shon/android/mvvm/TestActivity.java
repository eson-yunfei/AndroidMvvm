package com.shon.android.mvvm;

import android.os.Bundle;

import com.shon.android.mvvm.databinding.ActivityTestBinding;
import com.shon.android.mvvm.databinding.ActivityTestDataBindingBinding;
import com.shon.mvvm.base.ui.BaseBindingActivity;

import org.jetbrains.annotations.Nullable;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/31 19:57
 * Package name : com.shon.android.mvvm
 * Des :
 */
public class TestActivity extends BaseBindingActivity<ActivityTestDataBindingBinding> {

    @Override
    public int getLayoutID() { return R.layout.activity_test_data_binding; }

    @Override
    public void onProcess(@Nullable Bundle savedInstanceState) {

    }
}
