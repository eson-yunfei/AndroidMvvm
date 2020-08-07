package com.shon.android.mvvm.Base2;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.shon.mvvm.base.ui.BaseBindingActivity;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/5 00:01
 * Package name : com.shon.android.mvvm.Base2
 * Des :
 */
public abstract class Base2Activity<V,VM extends BaseViewModel> extends BaseBindingActivity<V> {
    protected  VM viewModel;

    @Override
    public void initViewState() {
        super.initViewState();
        viewModel = getViewModels();
        if (viewModel != null){
            viewModel.attach(binding);
        }
    }

    protected VM getViewModels() {
        return null;
    }

    @Override
    public void onProcess(@Nullable Bundle savedInstanceState) {

    }
}
