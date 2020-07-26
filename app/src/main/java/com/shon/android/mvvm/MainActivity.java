package com.shon.android.mvvm;

import android.os.Bundle;

import com.shon.mvvm.annotation.BindingView;
import com.shon.android.mvvm.databinding.ActivityMainBinding;
import com.shon.mvvm.base.activity.ViewBindingActivity;

@BindingView(ActivityMainBinding.class)
public class MainActivity extends ViewBindingActivity<ActivityMainBinding> {

    @Override
    protected void onProcess(Bundle savedInstanceState) {

    }


}