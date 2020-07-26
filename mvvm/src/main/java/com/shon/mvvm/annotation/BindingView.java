package com.shon.mvvm.annotation;

import androidx.viewbinding.ViewBinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 14:40
 * Package name : com.shon.mvvm.annotation
 * Des :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindingView {
    Class<? extends ViewBinding> value();
}
