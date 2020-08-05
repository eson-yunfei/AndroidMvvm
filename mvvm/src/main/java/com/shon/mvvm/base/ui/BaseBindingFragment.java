package com.shon.mvvm.base.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.shon.mvvm.base.imp.ICreate;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 23:38
 * Package name : com.shon.mvvm.base.ui
 * Des :
 */
public abstract class BaseBindingFragment<Binding> extends Fragment implements ICreate {

    protected Binding binding;

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutID() == 0) {
            binding = BindingUtil.createBinding(this, inflater, container);
            return (((ViewBinding) binding).getRoot());
        } else {

            binding = (Binding) DataBindingUtil.inflate(inflater, getLayoutID(), container, false);
            return (((ViewDataBinding) binding).getRoot());
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewState();
        initViewListener();
        onProcess(savedInstanceState);
    }

    @Override
    public void initViewState() {

    }

    @Override
    public void initViewListener() {

    }

    @Override
    public void onProcess(@Nullable Bundle savedInstanceState) {

    }
}
