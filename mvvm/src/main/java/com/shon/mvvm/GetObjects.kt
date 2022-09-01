package com.shon.mvvm

import android.util.Log
import android.view.LayoutInflater
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

/**
 *
 * @Author xiao
 * @Date 2022-09-01 15:39
 *
 */

object GetObjects {

    /**
     * 获取当前类绑定的泛型ViewModel-clazz
     */
    @Suppress("UNCHECKED_CAST")
    fun <VM> getVMClazz(obj: Any): VM {
        val actualTypeArguments =
            (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments

        Log.d("Get genericity", "getVmClazz actualTypeArguments[0] = " + actualTypeArguments[0])

        return actualTypeArguments[0] as VM
    }


    /**
     * 获取当前类绑定的泛型ViewBinding-clazz
     */
    @Suppress("UNCHECKED_CAST")
    fun <VB> getVBInstance(obj: Any, inflater: LayoutInflater): VB {
        val actualTypeArguments =
            (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments
        Log.d("Get getVBInstance", "getVmClazz actualTypeArguments[1] = " + actualTypeArguments[1])

        val javaClass: Class<VB> = actualTypeArguments[1] as Class<VB>
        val method: Method = javaClass.getMethod("inflate", LayoutInflater::class.java)

        val viewBinding = method.invoke(javaClass, inflater)
        return viewBinding as VB
    }
}