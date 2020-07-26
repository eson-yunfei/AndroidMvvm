package com.shon.mvvm.base.activity;

import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.shon.mvvm.annotation.BindingView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 14:42
 * Package name : com.shon.android.mvvm
 * Des :
 */
class ViewBindingInject {


    public static void injectViewBinding(AppCompatActivity appCompatActivity) {

        Class<? extends AppCompatActivity> activityClass = appCompatActivity.getClass();
        BindingView viewBind = activityClass.getAnnotation(BindingView.class);
        if (viewBind == null) {
            return;
        }

        Class<? extends ViewBinding> viewBindingClass = viewBind.value();

        Field viewBindingField = null;
        try {
            viewBindingField = activityClass.getField("viewBinding");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method method = viewBindingClass.getMethod("inflate", LayoutInflater.class);

            ViewBinding viewBinding = (ViewBinding) method.invoke(viewBindingClass, appCompatActivity.getLayoutInflater());

            if (viewBindingField == null) {
                return;
            }
            viewBindingField.set(appCompatActivity, viewBinding);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
}
