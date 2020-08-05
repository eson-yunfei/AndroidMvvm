package com.shon.mvvm.base.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

    /**
     * activity 的 创建方式
     *
     * @param appCompatActivity AppCompatActivity
     * @param <Binding> Binding
     * @return <Binding> Binding
     */
    public static <Binding> Binding createBinding(@NonNull AppCompatActivity appCompatActivity) {
        LayoutInflater layoutInflater = appCompatActivity.getLayoutInflater();
        Class<? extends ViewBinding> viewBindClass = findViewBinding(appCompatActivity);
        return createViewBinding(viewBindClass, layoutInflater);
    }

    /**
     * fragment 的创建方式
     *
     * @param fragment Fragment
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param <Binding> Binding
     * @return Binding
     */
    public static <Binding> Binding createBinding(@NonNull Fragment fragment, @NonNull LayoutInflater inflater,
                                                  @Nullable ViewGroup container) {

        Class<? extends ViewBinding> viewBinding = findViewBinding(fragment);
        return createViewBinding(viewBinding, inflater, container);
    }

    /**
     * 找到 ViewBinding 的 class
     *
     * @param object obj : activity 或者 fragment
     * @return Class<? extends ViewBinding>
     */
    @SuppressWarnings("unchecked")
    private static Class<? extends ViewBinding> findViewBinding(Object object) {
        Type type = object.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();

        if (types.length == 0) {
            return null;
        }

        return (Class<? extends ViewBinding>) types[0];
    }


    /**
     * 得到 Binding 的实例
     *
     * @param viewBindingClass Class<? extends ViewBinding>
     * @param layoutInflater LayoutInflater
     * @param <Binding> Binding
     * @return Binding
     */
    @SuppressWarnings("unchecked")
    private static <Binding> Binding createViewBinding(Class<? extends ViewBinding> viewBindingClass,
                                                       LayoutInflater layoutInflater) {

        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class);

            ViewBinding viewBinding = (ViewBinding) method.invoke(viewBindingClass, layoutInflater);

            return (Binding) viewBinding;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到 Binding 的实例
     *
     * @param viewBindingClass Class<? extends ViewBinding>
     * @param layoutInflater LayoutInflater
     * @param container ViewGroup
     * @param <Binding> Binding
     * @return Binding
     */
    @SuppressWarnings("unchecked")
    private static <Binding> Binding createViewBinding(Class<? extends ViewBinding> viewBindingClass,
                                                       LayoutInflater layoutInflater,
                                                       @Nullable ViewGroup container) {

        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);

            ViewBinding viewBinding = (ViewBinding) method.invoke(viewBindingClass, layoutInflater, container, false);

            return (Binding) viewBinding;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
