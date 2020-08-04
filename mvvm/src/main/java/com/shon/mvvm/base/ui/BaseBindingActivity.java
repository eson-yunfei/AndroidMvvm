package com.shon.mvvm.base.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewbinding.ViewBinding;

import com.shon.mvvm.base.imp.IActivityCreate;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 22:04
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
public abstract class BaseBindingActivity<Binding> extends AppCompatActivity implements IActivityCreate {

    protected Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //super 之前需要执行的代码
        onPreSuperCreate();

        super.onCreate(savedInstanceState);

        //在 setContentView 之前 需要调用 的代码
        onPreSetContentView();

        setBindingLayout();

        initViewState();

        initViewListener();

        onProcess(savedInstanceState);
    }

    /**
     * 初始化  ViewBinding 或者 ViewDataBinding
     * 并且 setContentView
     */
    @SuppressWarnings("unchecked")
    private void setBindingLayout() {
        if (getLayoutID() == 0) {
            binding = BindingUtil.createBinding(this);
            if (binding == null) {
                throw new NullPointerException("binding is null");
            }
            setContentView(((ViewBinding) binding).getRoot());
        } else {
            binding = (Binding) DataBindingUtil.setContentView(this, getLayoutID());
            setContentView(((ViewDataBinding) binding).getRoot());
        }
    }


    @Override
    public int getLayoutID() {
        return 0;
    }

    @Override
    public void onPreSuperCreate() {

    }

    @Override
    public void onPreSetContentView() {

    }

    @Override
    public void initViewState() {

    }

    @Override
    public void initViewListener() {

    }

}
