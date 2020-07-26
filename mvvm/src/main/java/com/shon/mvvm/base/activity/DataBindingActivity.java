package com.shon.mvvm.base.activity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 15:12
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
public abstract class DataBindingActivity<DB extends ViewDataBinding> extends BindingActivity<DataBindingActivity<?>> {

    @Override
    protected void setBindingContentView() {
        DataBindingUtil.setContentView(this,getLayoutId());
    }

    protected abstract int getLayoutId();
}
