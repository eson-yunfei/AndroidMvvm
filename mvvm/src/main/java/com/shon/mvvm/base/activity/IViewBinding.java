package com.shon.mvvm.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/31 19:52
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
public interface IViewBinding {
    void initViewState();

    void initViewListener();

    void onProcess(@Nullable Bundle savedInstanceState);
}
