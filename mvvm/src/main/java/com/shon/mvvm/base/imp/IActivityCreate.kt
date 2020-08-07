package com.shon.mvvm.base.imp

/**
 * Auth : xiao_yun_fei
 * Date : 2020/8/4 23:34
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
interface IActivityCreate : ICreate {
    /**
     * 在Activity 的 super 之前调用，需要用到时，请重写此方法
     */
    fun onPreSuperCreate()

    /**
     * 在Activity的 super 之后调用， 在 setContentView 之前调用
     */
    fun onPreSetContentView()
}