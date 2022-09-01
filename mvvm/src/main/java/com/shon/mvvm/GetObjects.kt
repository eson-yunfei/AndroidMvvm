package com.shon.mvvm

import android.content.res.Resources
import android.view.LayoutInflater
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

/**
 *
 * @Author xiao
 * @Date 2022-09-01 15:39
 *
 */

internal object GetObjects {

    /**
     * 获取当前类绑定的泛型ViewModel-clazz
     */
    @Suppress("UNCHECKED_CAST")
    fun <VM> getVMClazz(obj: Any): VM {
        obj.javaClass.genericInterfaces
        val superclass = obj.javaClass.genericSuperclass as ParameterizedType

        val actualTypeArguments = superclass.actualTypeArguments

        if (actualTypeArguments.isNotEmpty()) {
            return actualTypeArguments[0] as VM
        } else {
            throw Resources.NotFoundException("Cannot find generic parameter from direct parent class!(不能从直接父类找到泛型参数!)")
        }
    }


    /**
     * 获取当前类绑定的泛型ViewBinding-clazz
     */
    @Suppress("UNCHECKED_CAST")
    fun <VB> getVBInstance(obj: Any, inflater: LayoutInflater): VB {
        val parameterizedType = obj.javaClass.genericSuperclass as ParameterizedType
        val actualTypeArguments = parameterizedType.actualTypeArguments
        if (actualTypeArguments.size >1) {
            val javaClass: Class<VB> = actualTypeArguments[1] as Class<VB>
            val method: Method = javaClass.getMethod("inflate", LayoutInflater::class.java)
            val viewBinding = method.invoke(javaClass, inflater)
            return viewBinding as VB
        }else{
            throw Resources.NotFoundException("Cannot find generic parameter from direct parent class!(不能从直接父类找到泛型参数!)")
        }
    }
}