package com.shon.mvvm.base.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 14:34
 * Package name : com.shon.mvvm.base
 * Des :
 */
abstract class BindingActivity<T> extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //之前 super.onCreate 之前的代码
        onPreSuperCreate(savedInstanceState);

        super.onCreate(savedInstanceState);

        //执行 setContentView() 之前的代码
        onPreSetContentView(savedInstanceState);

        //执行setContentView.
        setBindingContentView();

        initDefaultView();

        initViewListeners();

        onProcess(savedInstanceState);
    }





    protected abstract void setBindingContentView();

    protected abstract void onProcess(Bundle savedInstanceState);

    /**
     * 在 super.onCreate(savedInstanceState) 之前 需要执行的代码
     *
     * @param savedInstanceState savedInstanceState
     */
    protected void onPreSetContentView(@Nullable Bundle savedInstanceState) {

    }

    /**
     * 在  setContentView() 之前 需要执行的代码
     *
     * @param savedInstanceState savedInstanceState
     */
    protected void onPreSuperCreate(@Nullable Bundle savedInstanceState) {

    }


    /**
     * 初始化默认界面显示。
     * <p>
     * 例如： 复用标题布局 ，需要设置标题显示。
     */
    protected void initDefaultView() {

    }

    private void initViewListeners() {


    }
}
