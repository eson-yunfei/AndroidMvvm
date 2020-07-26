package com.shon.mvvm.base.activity;

import androidx.viewbinding.ViewBinding;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 14:32
 * Package name : com.shon.mvvm.base
 * Des :
 */
public abstract class ViewBindingActivity<VM extends ViewBinding> extends BindingActivity<ViewBindingActivity<?>> {

    public VM viewBinding;

    @Override
    protected void setBindingContentView() {
        ViewBindingInject.injectViewBinding(this);
    }


}
