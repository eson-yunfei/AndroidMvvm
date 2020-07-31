package com.shon.mvvm.base.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 14:42
 * Package name : com.shon.android.mvvm
 * Des :
 */
class ViewBindingInject {

    private static String TAG = ViewBindingInject.class.getSimpleName();

    public static void injectViewBinding(AppCompatActivity appCompatActivity) {

        Class<? extends AppCompatActivity> activityClass = appCompatActivity.getClass();

        Log.d(TAG, "injectViewBinding :" + activityClass.getName());

        Field viewBindingField = null;
        try {
            viewBindingField = activityClass.getField("viewBinding");
        } catch (Exception e) {
            Log.e(TAG, "没有找到 变量 viewBinding ");
            e.printStackTrace();
        }
        if (setViewBinding(appCompatActivity, viewBindingField)) {
            Log.e(TAG, "初始化 viewBinding  失败");
            return;
        }
        Log.d(TAG, "初始化 viewBinding  成功，开始 setContentView()");
        try {
            Method setContentView = activityClass.getMethod("setContentView", View.class);
            if (viewBindingField == null) {
                return;
            }
            ViewBinding viewBinding = (ViewBinding) viewBindingField.get(appCompatActivity);
            if (viewBinding == null) {
                return;
            }
            setContentView.invoke(appCompatActivity, viewBinding.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean setViewBinding(AppCompatActivity appCompatActivity, Field viewBindingField) {
        Type genType = appCompatActivity.getClass().getGenericSuperclass();

        if (genType == null) {
            return true;
        }
        Type[] argument = ((ParameterizedType) genType).getActualTypeArguments();

        @SuppressWarnings("unchecked")
        Class<? extends ViewBinding> viewBindingClass = (Class<? extends ViewBinding>) argument[0];
        Log.d(TAG,"viewBindingClass : "+ viewBindingClass.getName());
        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class);

            ViewBinding viewBinding = (ViewBinding) method.invoke(viewBindingClass, appCompatActivity.getLayoutInflater());

            if (viewBindingField == null) {
                return true;
            }
            viewBindingField.set(appCompatActivity, viewBinding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
