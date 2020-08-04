package com.shon.mvvm.base.ui;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 22:07
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
class BindingUtil {

    public static <Binding> Binding createBinding(Object object) {
        LayoutInflater layoutInflater = null;
        if (object instanceof AppCompatActivity) {
            layoutInflater = ((AppCompatActivity) object).getLayoutInflater();
        }
        if (object instanceof Fragment) {
            layoutInflater = ((Fragment) object).getLayoutInflater();
        }

        if (layoutInflater == null) {
            return null;
        }
        Type type = object.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();

        if (types.length == 0) {
            return null;
        }

        Class<?> bindClass = (Class<?>) types[0];

        return createViewBinding((Class<? extends ViewBinding>) bindClass, layoutInflater);

    }


    private static <Binding> Binding createViewBinding(Class<? extends ViewBinding> viewBindingClass, LayoutInflater layoutInflater) {

        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class);

            ViewBinding viewBinding = (ViewBinding) method.invoke(viewBindingClass, layoutInflater);

            return (Binding) viewBinding;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
