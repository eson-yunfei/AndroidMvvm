package com.shon.mvvm.interfaces

/**
 *
 * @Author xiao
 * @Date 2022-09-01 17:00
 *
 */
interface IPageCreate {

    fun onPreCreateView(){}

    fun onInitView()

    fun onInitListener()

    fun onInitData()
}