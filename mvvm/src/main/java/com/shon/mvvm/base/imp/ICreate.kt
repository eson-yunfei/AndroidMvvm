package com.shon.mvvm.base.imp

import android.os.Bundle
import androidx.annotation.LayoutRes

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/31 19:52
 * Package name : com.shon.mvvm.base.activity
 * Des :
 */
interface ICreate {
    /**
     * 返回页面 布局的 Layout id
     * @return @LayoutRes id
     */
    @get:LayoutRes
    val layoutID: Int

    /**
     * 初始化 view 的状态，例如 显示、 隐藏、等
     */
    fun initViewState()

    /**
     * 设置 view 的 监听事件， 例如 点击、长按、选择、输入监听等
     */
    fun initViewListener()

    /**
     * 其他的操作，
     * @param savedInstanceState savedInstanceState
     */
    fun onProcess(savedInstanceState: Bundle?)
}